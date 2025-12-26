package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compatibility")
public class CompatibilityController {

    private final CompatibilityScoreService compatibilityScoreService;

    public CompatibilityController(
            CompatibilityScoreService compatibilityScoreService) {
        this.compatibilityScoreService = compatibilityScoreService;
    }

    @PostMapping("/calculate/{studentAId}/{studentBId}")
    public ResponseEntity<CompatibilityScoreRecord> calculateScore(
            @PathVariable Long studentAId,
            @PathVariable Long studentBId) {

        return ResponseEntity.ok(
                compatibilityScoreService.calculateCompatibility(
                        studentAId, studentBId)
        );
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<CompatibilityScoreRecord>> getScores(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                compatibilityScoreService.getCompatibilityRecordsForStudent(
                        studentId)
        );
    }
}
