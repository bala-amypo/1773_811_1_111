package com.example.demo.controller;

import com.example.demo.entity.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match-attempts")
@Tag(name = "Match Attempts", description = "Operations on match attempts")
public class MatchAttemptController {

    @Autowired
    private MatchAttemptRepository repo;

    @Operation(summary = "Log match attempt")
    @PostMapping
    public MatchAttemptRecord logAttempt(@RequestBody MatchAttemptRecord attempt) {
        return repo.save(attempt);
    }

    @Operation(summary = "Update attempt status")
    @PutMapping("/{id}/status")
    public ResponseEntity<MatchAttemptRecord> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return repo.findById(id).map(attempt -> {
            attempt.setStatus(status);
            repo.save(attempt);
            return ResponseEntity.ok(attempt);
        }).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get attempts involving a student")
    @GetMapping("/student/{studentid}")
    public List<MatchAttemptRecord> getAttemptsByStudent(@PathVariable Long studentid) {
        return repo.findByStudentId(studentid);
    }

    @Operation(summary = "Get attempt by ID")
    @GetMapping("/{id}")
    public ResponseEntity<MatchAttemptRecord> getAttempt(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "List all attempts")
    @GetMapping
    public List<MatchAttemptRecord> getAllAttempts() {
        return repo.findAll();
    }
}
