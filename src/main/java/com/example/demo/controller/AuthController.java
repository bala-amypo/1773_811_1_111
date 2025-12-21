package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "User registration and login")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Operation(summary = "Register new user")
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userRepo.save(user));
    }

    @Operation(summary = "Login user")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User existing = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (existing != null) return ResponseEntity.ok("Login successful");
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
