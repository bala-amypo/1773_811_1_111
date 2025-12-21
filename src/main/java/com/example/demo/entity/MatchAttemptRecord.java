package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class MatchAttemptRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;

    // getters & setters
}
