package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private double score;

    public void setStudentAId(Long studentAId) {
        this.studentAId = studentAId;
    }

    public void setStudentBId(Long studentBId) {
        this.studentBId = studentBId;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
