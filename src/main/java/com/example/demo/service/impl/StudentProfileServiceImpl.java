package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    public StudentProfile create(StudentProfile s) {
        if (s.getAge() <= 0)
            throw new IllegalArgumentException("age must be > 0");
        return repo.save(s);
    }

    public List<StudentProfile> getAll() {
        return repo.findAll();
    }
}
