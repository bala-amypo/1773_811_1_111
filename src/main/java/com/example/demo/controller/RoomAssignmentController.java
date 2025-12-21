package com.example.demo.controller;

import com.example.demo.entity.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-assignments")
@Tag(name = "Room Assignments", description = "Operations on room assignments")
public class RoomAssignmentController {

    @Autowired
    private RoomAssignmentRepository repo;

    @Operation(summary = "Assign room")
    @PostMapping
    public RoomAssignmentRecord assignRoom(@RequestBody RoomAssignmentRecord record) {
        return repo.save(record);
    }

    @Operation(summary = "Update room assignment status")
    @PutMapping("/{id}/status")
    public ResponseEntity<RoomAssignmentRecord> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return repo.findById(id).map(record -> {
            record.setStatus(status);
            repo.save(record);
            return ResponseEntity.ok(record);
        }).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get all assignments for a student")
    @GetMapping("/student/{studentid}")
    public List<RoomAssignmentRecord> getAssignmentsByStudent(@PathVariable Long studentid) {
        return repo.findByStudentId(studentid);
    }

    @Operation(summary = "Get assignment by ID")
    @GetMapping("/{id}")
    public ResponseEntity<RoomAssignmentRecord> getAssignment(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "List all room assignments")
    @GetMapping
    public List<RoomAssignmentRecord> getAllAssignments() {
        return repo.findAll();
    }
}
