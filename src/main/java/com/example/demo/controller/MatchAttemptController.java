package com.example.demo.controller;

import com.example.demo.service.MatchAttemptService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match-attempt")
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    @PostMapping
    public String record(@RequestParam Long a,
                         @RequestParam Long b) {
        service.recordAttempt(a, b);
        return "Match attempt recorded";
    }
}
