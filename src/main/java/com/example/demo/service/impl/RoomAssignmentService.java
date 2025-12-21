package com.example.demo.service.impl;

import com.example.demo.entity.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repo) {
        this.repo = repo;
    }

    public void assignRoom(Long studentId) {
        RoomAssignmentRecord r = new RoomAssignmentRecord();
        r.setStudentId(studentId);
        r.setRoomNumber("ROOM-" + studentId);
        repo.save(r);
    }
}
