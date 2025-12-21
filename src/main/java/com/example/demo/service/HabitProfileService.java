package com.example.demo.service;

import com.example.demo.entity.HabitProfile;

public interface HabitProfileService {
    HabitProfile save(Long studentId, HabitProfile habit);
}
