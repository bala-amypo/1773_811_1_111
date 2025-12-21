package com.example.demo.controller;

import com.example.demo.entity.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compatibility")
@Tag(name = "Compatibility Scores", description = "Operations on compatibility scores")
public class CompatibilityScoreController {

    @Autowired
    private CompatibilityScoreService scoreService;

    @Operation(summary = "Compute compatibility score between two students")
    @PostMapping("/compute/{studentAid}/{studentBid}")
    public CompatibilityScoreRecord computeScore(@PathVariable Long studentAid, @PathVariable Long studentBid) {
        return scoreService.calculate(studentAid, studentBid);
    }

    @Operation(summary = "Get all scores for a student")
    @GetMapping("/student/{studentid}")
    public List<CompatibilityScoreRecord> getScoresByStudent(@PathVariable Long studentid) {
        return scoreService.getScoresForStudent(studentid);
    }

    @Operation(summary = "Get score by ID")
    @GetMapping("/{id}")
    public CompatibilityScoreRecord getScore(@PathVariable Long id) {
        return scoreService.getScoreById(id);
    }

    @Operation(summary = "List all compatibility scores")
    @GetMapping
    public List<CompatibilityScoreRecord> getAllScores() {
        return scoreService.getAllScores();
    }
}
