package com.example.demo.service.impl;

import com.example.demo.entity.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repo) {
        this.repo = repo;
    }

    public void recordAttempt(Long aId, Long bId) {
        MatchAttemptRecord r = new MatchAttemptRecord();
        r.setStudentAId(aId);
        r.setStudentBId(bId);
        repo.save(r);
    }
}
