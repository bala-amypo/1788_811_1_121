package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamRoom;
import com.example.demo.model.ExamSession;
import com.example.demo.model.SeatingPlan;
import com.example.demo.model.Student;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.SeatingPlanRepository;
import com.example.demo.service.SeatingPlanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final ExamSessionRepository sessionRepository;
    private final SeatingPlanRepository planRepository;
    private final ExamRoomRepository roomRepository;

    public SeatingPlanServiceImpl(ExamSessionRepository sessionRepository,
                                  SeatingPlanRepository planRepository,
                                  ExamRoomRepository roomRepository) {
        this.sessionRepository = sessionRepository;
        this.planRepository = planRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public SeatingPlan generatePlan(Long sessionId) {
        ExamSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ApiException("Session not found"));

        List<ExamRoom> rooms = roomRepository.findAll();
        if (rooms.isEmpty()) {
            throw new ApiException("No room available");
        }

        int studentsCount = session.getStudents().size();
        ExamRoom selected = rooms.stream()
                .filter(r -> r.getCapacity() >= studentsCount)
                .findFirst()
                .orElseThrow(() -> new ApiException("No room with sufficient capacity"));

        Map<String, String> arrangement = new LinkedHashMap<>();
        for (Student s : session.getStudents()) {
            arrangement.put(s.getRollNumber(), selected.getRoomNumber());
        }

        try {
            String json = new ObjectMapper().writeValueAsString(arrangement);
            SeatingPlan plan = SeatingPlan.builder()
                    .examSession(session)
                    .room(selected)
                    .arrangementJson(json)
                    .generatedAt(LocalDateTime.now())
                    .build();
            return planRepository.save(plan);
        } catch (Exception e) {
            throw new ApiException("Failed to generate plan");
        }
    }

    @Override
    public SeatingPlan getPlan(Long id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new ApiException("Plan not found"));
    }

    @Override
    public List<SeatingPlan> getPlansBySession(Long sessionId) {
        return planRepository.findByExamSessionId(sessionId);
    }
}
