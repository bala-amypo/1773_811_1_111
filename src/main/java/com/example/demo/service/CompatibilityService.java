package com.example.demo.service;

import com.example.demo.model.CompatibilityScoreRecord;
import java.util.List;

public interface CompatibilityScoreService {

    CompatibilityScoreRecord calculateCompatibility(Long studentAId, Long studentBId);

    List<CompatibilityScoreRecord> getCompatibilityRecordsForStudent(Long studentId);
}
