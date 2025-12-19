package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seating_plan")
public class SeatingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK to ExamSession
    @ManyToOne
    @JoinColumn(name = "exam_session_id")
    private ExamSession examSession;

    // FK to Location
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private Integer seatNumber;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public ExamSession getExamSession() {
        return examSession;
    }

    public Location getLocation() {
        return location;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setExamSession(ExamSession examSession) {
        this.examSession = examSession;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }
}
