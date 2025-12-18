package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(uniqueConstraints = {
@UniqueConstraint(columnNames = "studentId"),
@UniqueConstraint(columnNames = "email")
})
public class StudentProfile {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String studentId;
private String fullName;
private String email;
private String department;
private Integer yearLevel;
private boolean active;
private LocalDateTime createdAt = LocalDateTime.now();
public void setStudentAId(Long studentAId) {
    this.studentAId = studentAId;
}




}