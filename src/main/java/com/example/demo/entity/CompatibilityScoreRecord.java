@ManyToOne
private StudentProfile studentA;

@ManyToOne
private StudentProfile studentB;

public void setStudentA(StudentProfile studentA) {
    this.studentA = studentA;
}

public void setStudentB(StudentProfile studentB) {
    this.studentB = studentB;
}
