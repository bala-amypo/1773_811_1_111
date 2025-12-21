package com.example.demo.service.impl;

import com.example.demo.entity.HabitProfile;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository habitRepo;
    private final StudentProfileRepository studentRepo;

    public HabitProfileServiceImpl(HabitProfileRepository h,
                                   StudentProfileRepository s) {
        this.habitRepo = h;
        this.studentRepo = s;
    }

    public HabitProfile save(Long studentId, HabitProfile habit) {
        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        habit.setStudent(student);
        return habitRepo.save(habit);
    }
}
