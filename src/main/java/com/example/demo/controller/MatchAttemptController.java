package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match-attempt")
public class MatchAttemptController {

    @PostMapping
    public String attempt() {
        return "Match attempt recorded";
    }
}
