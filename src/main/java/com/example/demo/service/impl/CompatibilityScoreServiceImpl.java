package com.example.demo.service.impl;

import com.example.demo.entity.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    @Override
    public CompatibilityScoreRecord calculate(Long studentAId, Long studentBId) {

        CompatibilityScoreRecord record = new CompatibilityScoreRecord();
        record.setStudentAId(studentAId);
        record.setStudentBId(studentBId);
        record.setScore(75.0);

        return record;
    }
}
