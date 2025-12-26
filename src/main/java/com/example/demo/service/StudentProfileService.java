package com.example.demo.service;

import com.example.demo.model.StudentProfile;
import java.util.List;

public interface StudentProfileService {

    StudentProfile createStudentProfile(StudentProfile studentProfile);

    StudentProfile getStudentProfileById(Long id);

    List<StudentProfile> getAllStudentProfiles();
}
