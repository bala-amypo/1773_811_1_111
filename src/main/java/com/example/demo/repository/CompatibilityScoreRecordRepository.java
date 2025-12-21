package com.example.demo.repository;

import com.example.demo.entity.CompatibilityScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompatibilityScoreRecordRepository
        extends JpaRepository<CompatibilityScoreRecord, Long> {

    List<CompatibilityScoreRecord>
    findByStudentAIdOrStudentBIdOrderByScoreDesc(Long a, Long b);
}
