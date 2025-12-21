package com.example.demo.service.impl;

import com.example.demo.entity.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repository;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public void assignRoom(Long studentId) {
        RoomAssignmentRecord record = new RoomAssignmentRecord();
        record.setStudentId(studentId);
        record.setRoomNumber("ROOM-" + studentId); // simple deterministic room
        repository.save(record);
    }
}
