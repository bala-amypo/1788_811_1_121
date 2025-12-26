package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seating_plan")
public class SeatingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String roomNumber;

    @Column(nullable = false)
    private String rollNumber;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private ExamSession session;

    // =====================
    // Constructors
    // =====================

    public SeatingPlan() {
    }

    // =====================
    // Getters & Setters
    // =====================

    public Long getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public ExamSession getSession() {
        return session;
    }

    public void setSession(ExamSession session) {
        this.session = session;
    }
}
