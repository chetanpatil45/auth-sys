package com.auth_sys.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@Tag(name = "Admin")
public class AdminController {
    @GetMapping
    public ResponseEntity<String> adminEndpoint(){
        return ResponseEntity.ok("Hello Admin, you can see this.");
    }
}
