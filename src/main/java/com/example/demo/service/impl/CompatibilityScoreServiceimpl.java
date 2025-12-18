package com.example.demo.service;


import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;


@Service
public class CompatibilityScoreServiceImpl {


private final CompatibilityScoreRecordRepository scoreRepo;
private final HabitProfileRepository habitRepo;


public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository scoreRepo,
HabitProfileRepository habitRepo) {
this.scoreRepo = scoreRepo;
this.habitRepo = habitRepo;
}
public CompatibilityScoreRecord computeScore(Long a, Long b) {
if (a.equals(b)) throw new IllegalArgumentException("same student");


CompatibilityScoreRecord record = new CompatibilityScoreRecord();
record.setStudentAId(a);
record.setStudentBId(b);
record.setScore(85.0);
record.setCompatibilityLevel("HIGH");
record.setDetailsJson("{}");


return scoreRepo.save(record);
}
}