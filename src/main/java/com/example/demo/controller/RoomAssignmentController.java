package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomAssignmentController {

    @PostMapping("/{studentId}")
    public String assign(@PathVariable Long studentId) {
        return "Room assigned to student " + studentId;
    }
}
