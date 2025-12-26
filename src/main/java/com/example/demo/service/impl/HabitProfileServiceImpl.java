package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        if (habit.getStudyHoursPerDay() != null && habit.getStudyHoursPerDay() < 0) {
            throw new IllegalArgumentException("study hours invalid");
        }

        Optional<HabitProfile> existing = repo.findByStudentId(habit.getStudentId());
        if (existing.isPresent()) {
            HabitProfile h = existing.get();
            h.setStudyHoursPerDay(habit.getStudyHoursPerDay());
            h.setSleepSchedule(habit.getSleepSchedule());
            h.setCleanlinessLevel(habit.getCleanlinessLevel());
            h.setNoiseTolerance(habit.getNoiseTolerance());
            h.setSocialPreference(habit.getSocialPreference());
            h.setUpdatedAt(LocalDateTime.now());
            return repo.save(h);
        }

        habit.setUpdatedAt(LocalDateTime.now());
        return repo.save(habit);
    }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) {
        return repo.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));
    }

    @Override
    public Optional<HabitProfile> getHabitById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repo.findAll();
    }
}
