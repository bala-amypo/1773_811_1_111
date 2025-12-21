package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentA;

    @ManyToOne
    private StudentProfile studentB;

    private double score;

    // getters & setters
}
