package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class MatchAttemptRecord {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private Long initiatorStudentId;
private Long candidateStudentId;
private Long resultScoreId;
private String status;
private LocalDateTime attemptedAt = LocalDateTime.now();


}