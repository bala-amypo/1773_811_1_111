package com.example.demo.controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomAssignmentController {

    private final RoomAssignmentService roomAssignmentService;

    public RoomAssignmentController(
            RoomAssignmentService roomAssignmentService) {
        this.roomAssignmentService = roomAssignmentService;
    }

    @PostMapping("/{studentAId}/{studentBId}")
    public ResponseEntity<RoomAssignmentRecord> assignRoom(
            @PathVariable Long studentAId,
            @PathVariable Long studentBId) {

        return ResponseEntity.ok(
                roomAssignmentService.assignRoom(studentAId, studentBId)
        );
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<RoomAssignmentRecord>> getRoomAssignments(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                roomAssignmentService.getRoomAssignmentsForStudent(studentId)
        );
    }
}
