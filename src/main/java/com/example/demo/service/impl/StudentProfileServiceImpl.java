package com.example.demo.service;

import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl {

    private final StudentProfileRepository studentProfileRepository;
    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }
    public StudentProfile createStudent(StudentProfile profile) {

        studentProfileRepository.findByStudentId(profile.getStudentId())
                .ifPresent(existing -> {
                    throw new IllegalArgumentException("studentId exists");
                });

        return studentProfileRepository.save(profile);
    }
    public StudentProfile getStudentById(Long id) {
        return studentProfileRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException("not found"));
    }
    public List<StudentProfile> getAllStudents() {
        return studentProfileRepository.findAll();
    }
    public StudentProfile findByStudentId(String studentId) {
        return studentProfileRepository.findByStudentId(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("not found"));
    }
    public StudentProfile updateStudentStatus(Long id, boolean active) {
        StudentProfile student = getStudentById(id);
        student.setActive(active);
        return studentProfileRepository.save(student);
    }
}
