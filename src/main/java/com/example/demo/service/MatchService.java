package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import java.util.List;

public interface MatchService {

    MatchAttemptRecord attemptMatch(Long initiatorId, Long candidateId);

    List<MatchAttemptRecord> getMatchAttempts(Long studentId);
}
