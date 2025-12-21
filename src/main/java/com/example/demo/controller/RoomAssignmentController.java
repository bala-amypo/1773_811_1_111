package com.example.demo.controller;

import com.example.demo.service.RoomAssignmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    @PostMapping("/{studentId}")
    public String assign(@PathVariable Long studentId) {
        service.assignRoom(studentId);
        return "Room assigned";
    }
}
