package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(
            @RequestParam String username,
            @RequestParam String password) {

        if ("admin".equals(username) &&
                "admin123".equals(password)) {

            return ResponseEntity.ok(
                    Map.of("token",
                            jwtUtil.generateToken(username))
            );
        }

        throw new RuntimeException("Invalid credentials");
    }
}
