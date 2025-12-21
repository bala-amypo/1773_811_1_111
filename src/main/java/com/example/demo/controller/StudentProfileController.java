package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Profiles", description = "Operations on student profiles")
public class StudentProfileController {

    @Autowired
    private StudentProfileRepository studentRepo;

    @Operation(summary = "Create student profile")
    @PostMapping
    public ResponseEntity<StudentProfile> createStudent(@RequestBody StudentProfile student) {
        return ResponseEntity.ok(studentRepo.save(student));
    }

    @Operation(summary = "Get student by ID")
    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudent(@PathVariable Long id) {
        return studentRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "List all students")
    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return studentRepo.findAll();
    }

    @Operation(summary = "Activate/deactivate student")
    @PutMapping("/{id}/status")
    public ResponseEntity<StudentProfile> updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return studentRepo.findById(id).map(student -> {
            student.setActive(active);  // assuming `active` field exists
            studentRepo.save(student);
            return ResponseEntity.ok(student);
        }).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Lookup student by studentid")
    @GetMapping("/lookup/{studentid}")
    public ResponseEntity<StudentProfile> lookupStudent(@PathVariable String studentid) {
        StudentProfile student = studentRepo.findByStudentId(studentid); // implement findByStudentId in repo
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }
}
