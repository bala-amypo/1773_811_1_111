package com.example.demo.controller;


import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileServiceImpl;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentProfileController {


private final StudentProfileServiceImpl service;


public StudentProfileController(StudentProfileServiceImpl service) {
this.service = service;
}
@PostMapping
public StudentProfile create(@RequestBody StudentProfile s) {
return service.createStudent(s);
}


@GetMapping("/{id}")
public StudentProfile get(@PathVariable Long id) {
return service.getStudentById(id);
}


@GetMapping
public List<StudentProfile> all() {
return service.getAllStudents();
}
}