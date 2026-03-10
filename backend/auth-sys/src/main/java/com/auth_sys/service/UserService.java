package com.auth_sys.service;

import com.auth_sys.entity.User;
import com.auth_sys.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user){
        Optional<User> opUser = repository.findByEmail(user.getEmail());
        if (opUser.isPresent()){
            return null;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return repository.findByEmail(email);
    }
}
