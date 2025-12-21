package com.example.demo.repository;

import com.example.demo.entity.RoomAssignmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomAssignmentRecordRepository
        extends JpaRepository<RoomAssignmentRecord, Long> {}
