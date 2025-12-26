package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "seating_plan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_session_id")
    private ExamSession examSession;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private ExamRoom room;

    @Lob
    private String arrangementJson;

    private LocalDateTime generatedAt;
}
