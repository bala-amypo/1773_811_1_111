package com.example.demo.repository;


import com.example.demo.entity.RoomAssignmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface RoomAssignmentRecordRepository extends JpaRepository<RoomAssignmentRecord, Long> {
List<RoomAssignmentRecord> findByStudentAIdOrStudentBId(Long id1, Long id2);
}