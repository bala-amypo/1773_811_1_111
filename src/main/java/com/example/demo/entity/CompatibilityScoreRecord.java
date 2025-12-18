package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class CompatibilityScoreRecord {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private Long studentAId;
private Long studentBId;
private Double score;
private String compatibilityLevel;
private String detailsJson;
private LocalDateTime computedAt = LocalDateTime.now();

}