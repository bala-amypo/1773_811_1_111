package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private StudentProfile student;

    private int cleanliness;
    private int noiseLevel;
    private boolean smoking;

    // getters & setters
}
