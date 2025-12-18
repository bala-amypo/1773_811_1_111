package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class RoomAssignmentRecord {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String roomNumber;
private Long studentAId;
private Long studentBId;
private LocalDateTime assignedAt = LocalDateTime.now();
private String status;

}