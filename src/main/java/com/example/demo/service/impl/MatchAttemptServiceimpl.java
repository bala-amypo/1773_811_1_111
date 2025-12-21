package com.example.demo.service.impl;

import com.example.demo.entity.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repository;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public void recordAttempt(Long aId, Long bId) {
        MatchAttemptRecord record = new MatchAttemptRecord();
        record.setStudentAId(aId);
        record.setStudentBId(bId);
        repository.save(record);
    }
}
