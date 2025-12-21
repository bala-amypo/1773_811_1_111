package com.example.demo.service;

import com.example.demo.entity.CompatibilityScoreRecord;

public interface CompatibilityScoreService {

    CompatibilityScoreRecord calculate(Long studentAId, Long studentBId);
}
