package com.auth_sys.controller;

import com.auth_sys.dto.UserDto;
import com.auth_sys.entity.User;
import com.auth_sys.repository.UserRepository;
import com.auth_sys.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

//    @GetMapping
//    public ResponseEntity<String> userEndpoint(){
//        return ResponseEntity.ok("Hello user, you can see this.");
//    }

    @GetMapping("/me")
    public UserDto getCurrentUser(Authentication authentication) {
        User user = userRepository
                .findByEmail(authentication.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserDto.builder()
                .name(user.getName())
                .role(user.getRole())
                .email(user.getEmail())
                .build();
    }
}
