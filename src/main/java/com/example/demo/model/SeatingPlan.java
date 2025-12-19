package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "seating_plans")
public class SeatingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ExamSession examSession;

    @ManyToOne
    private ExamRoom room;

    @Lob
    private String arrangementJson;

    private LocalDateTime generatedAt;

    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    // getters & setters
}
