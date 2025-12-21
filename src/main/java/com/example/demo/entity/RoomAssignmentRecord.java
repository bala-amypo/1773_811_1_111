package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String roomNumber;

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
