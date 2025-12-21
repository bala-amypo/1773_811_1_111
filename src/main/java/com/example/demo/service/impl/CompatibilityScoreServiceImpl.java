package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    @Override
    public CompatibilityScoreRecord calculate(HabitProfile a, HabitProfile b) {

        double score = 100 - Math.abs(a.getCleanliness() - b.getCleanliness()) * 10;

        CompatibilityScoreRecord r = new CompatibilityScoreRecord();
        r.setStudentAId(a.getStudent().getId());
        r.setStudentBId(b.getStudent().getId());
        r.setScore(score);

        return r;
    }
}
