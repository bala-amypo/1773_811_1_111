package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import java.util.List;

public interface RoomAssignmentService {

    RoomAssignmentRecord assignRoom(Long studentAId, Long studentBId);

    List<RoomAssignmentRecord> getRoomAssignmentsForStudent(Long studentId);
}
