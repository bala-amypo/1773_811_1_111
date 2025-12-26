package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @PostMapping
    public ResponseEntity<StudentProfile> createStudent(
            @RequestBody StudentProfile studentProfile) {
        return ResponseEntity.ok(
                studentProfileService.createStudentProfile(studentProfile)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(
                studentProfileService.getStudentProfileById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllStudents() {
        return ResponseEntity.ok(
                studentProfileService.getAllStudentProfiles()
        );
    }
}
