package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habits")
public class HabitProfileController {

    private final HabitProfileService habitProfileService;

    public HabitProfileController(HabitProfileService habitProfileService) {
        this.habitProfileService = habitProfileService;
    }

    @PostMapping
    public ResponseEntity<HabitProfile> saveHabitProfile(
            @RequestBody HabitProfile habitProfile) {
        return ResponseEntity.ok(
                habitProfileService.saveHabitProfile(habitProfile)
        );
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<HabitProfile> getHabitProfile(
            @PathVariable Long studentId) {
        return ResponseEntity.ok(
                habitProfileService.getHabitProfileByStudentId(studentId)
        );
    }
}
