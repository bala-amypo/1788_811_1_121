package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "exam_session")
public class ExamSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    private LocalDate examDate;

    @ManyToMany
    @JoinTable(
        name = "exam_session_students",
        joinColumns = @JoinColumn(name = "exam_session_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    public ExamSession() {}

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
