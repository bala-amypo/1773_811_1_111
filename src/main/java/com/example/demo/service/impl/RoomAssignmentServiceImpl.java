package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repo;
    private final StudentProfileRepository studentRepo;

    public RoomAssignmentServiceImpl(
            RoomAssignmentRecordRepository repo,
            StudentProfileRepository studentRepo) {
        this.repo = repo;
        this.studentRepo = studentRepo;
    }

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord record) {
        StudentProfile a = studentRepo.findById(record.getStudentAId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        StudentProfile b = studentRepo.findById(record.getStudentBId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (!Boolean.TRUE.equals(a.getActive()) || !Boolean.TRUE.equals(b.getActive())) {
            throw new IllegalArgumentException("both students must be active");
        }

        record.setStatus(RoomAssignmentRecord.Status.ACTIVE);
        return repo.save(record);
    }

    @Override
    public RoomAssignmentRecord updateStatus(Long id, String status) {
        RoomAssignmentRecord r = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        r.setStatus(RoomAssignmentRecord.Status.valueOf(status));
        return repo.save(r);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId) {
        return repo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return repo.findAll();
    }
}
