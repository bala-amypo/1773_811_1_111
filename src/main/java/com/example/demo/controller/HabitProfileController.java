package com.example.demo.controller;

import com.example.demo.entity.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habits")
public class HabitProfileController {

    private final HabitProfileService service;

    public HabitProfileController(HabitProfileService service) {
        this.service = service;
    }

    @PostMapping("/{studentId}")
    public HabitProfile save(@PathVariable Long studentId,
                             @RequestBody HabitProfile habit) {
        return service.save(studentId, habit);
    }
}
