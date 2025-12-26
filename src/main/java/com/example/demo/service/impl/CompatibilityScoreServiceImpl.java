package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository scoreRepo;
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(
            CompatibilityScoreRecordRepository scoreRepo,
            HabitProfileRepository habitRepo) {
        this.scoreRepo = scoreRepo;
        this.habitRepo = habitRepo;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long aId, Long bId) {
        if (aId.equals(bId)) {
            throw new IllegalArgumentException("same student");
        }

        HabitProfile a = habitRepo.findByStudentId(aId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));
        HabitProfile b = habitRepo.findByStudentId(bId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));

        double score = 50.0;
        if (a.getSleepSchedule() == b.getSleepSchedule()) score += 10;
        if (a.getCleanlinessLevel() == b.getCleanlinessLevel()) score += 10;
        if (a.getNoiseTolerance() == b.getNoiseTolerance()) score += 10;
        if (a.getSocialPreference() == b.getSocialPreference()) score += 10;
        score += Math.max(0, 10 - Math.abs(a.getStudyHoursPerDay() - b.getStudyHoursPerDay()));

        CompatibilityScoreRecord rec = scoreRepo
                .findByStudentAIdAndStudentBId(aId, bId)
                .orElse(new CompatibilityScoreRecord());

        rec.setStudentAId(aId);
        rec.setStudentBId(bId);
        rec.setScore(Math.min(score, 100));
        rec.setComputedAt(LocalDateTime.now());

        if (score >= 90) rec.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.EXCELLENT);
        else if (score >= 75) rec.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.GOOD);
        else if (score >= 60) rec.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.FAIR);
        else rec.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.POOR);

        return scoreRepo.save(rec);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return scoreRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Score not found"));
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return scoreRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return scoreRepo.findAll();
    }
}
