package com.example.demo.controller;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/{initiatorId}/{candidateId}")
    public ResponseEntity<MatchAttemptRecord> attemptMatch(
            @PathVariable Long initiatorId,
            @PathVariable Long candidateId) {

        return ResponseEntity.ok(
                matchService.attemptMatch(initiatorId, candidateId)
        );
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<MatchAttemptRecord>> getMatchHistory(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                matchService.getMatchAttempts(studentId)
        );
    }
}
