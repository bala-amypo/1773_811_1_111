package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl {

    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    // Create student
    public StudentProfile createStudent(StudentProfile profile) {

        if (profile.getId() != null &&
            studentProfileRepository.findById(profile.getId()).isPresent()) {
            throw new IllegalArgumentException("studentId exists");
        }

        return studentProfileRepository.save(profile);
    }

    // Get by ID
    public StudentProfile getStudentById(Long id) {
        return studentProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    // Get all
    public List<StudentProfile> getAllStudents() {
        return studentProfileRepository.findAll();
    }
}
