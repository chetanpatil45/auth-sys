package com.auth_sys.controller;

import com.auth_sys.dto.LoginRequest;
import com.auth_sys.dto.LoginResponse;
import com.auth_sys.entity.User;
import com.auth_sys.service.JwtService;
import com.auth_sys.service.UserService;
import com.auth_sys.util.UserMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication")
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public AuthController(UserService userService, JwtService jwtService, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(userMapper.userToUserDto(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        Optional<User> opUser = userService.findByEmail(loginRequest.getEmail());
        LoginResponse loginResponse = new LoginResponse();

        if (opUser.isPresent()){
            User validUser = opUser.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), validUser.getPassword())){
                String token = jwtService.generateToken(validUser);
                loginResponse.setJwt(token);
                return ResponseEntity.ok(loginResponse);
            }

            loginResponse.setError("Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
        }
        loginResponse.setError("User not found");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
    }
}
