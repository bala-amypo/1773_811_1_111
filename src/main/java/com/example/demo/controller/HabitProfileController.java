package com.example.demo.controller;

import com.example.demo.entity.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
@Tag(name = "Habit Profiles", description = "Operations on habit profiles")
public class HabitProfileController {

    @Autowired
    private HabitProfileRepository habitRepo;

    @Operation(summary = "Create or update habit profile")
    @PostMapping
    public ResponseEntity<HabitProfile> saveHabit(@RequestBody HabitProfile habit) {
        return ResponseEntity.ok(habitRepo.save(habit));
    }

    @Operation(summary = "Get habit profile for student")
    @GetMapping("/student/{studentid}")
    public ResponseEntity<HabitProfile> getHabitByStudent(@PathVariable Long studentid) {
        HabitProfile habit = habitRepo.findByStudentId(studentid);
        return habit != null ? ResponseEntity.ok(habit) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Get habit profile by ID")
    @GetMapping("/{id}")
    public ResponseEntity<HabitProfile> getHabit(@PathVariable Long id) {
        return habitRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "List all habits")
    @GetMapping
    public List<HabitProfile> getAllHabits() {
        return habitRepo.findAll();
    }
}
