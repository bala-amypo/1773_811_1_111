package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final HabitProfileRepository habitRepo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public CompatibilityScoreServiceImpl(HabitProfileRepository h,
                                         CompatibilityScoreRecordRepository c) {
        this.habitRepo = h;
        this.scoreRepo = c;
    }

    public CompatibilityScoreRecord calculate(Long aId, Long bId) {

        HabitProfile a = habitRepo.findByStudentId(aId).orElseThrow();
        HabitProfile b = habitRepo.findByStudentId(bId).orElseThrow();

        double score = 100 - Math.abs(a.getCleanliness() - b.getCleanliness()) * 10;
        score = Math.max(0, Math.min(100, score));

        CompatibilityScoreRecord r = new CompatibilityScoreRecord();
        r.setStudentA(a.getStudent());
        r.setStudentB(b.getStudent());
        r.setScore(score);

        return scoreRepo.save(r);
    }
}
