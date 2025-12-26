package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.SeatingPlanService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.*;
@service
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
        ExamRoom selected = null;

        for (ExamRoom r : rooms) {
            if (r.getCapacity() >= studentsCount) {
                selected = r;
                break;
            }
        }

        if (selected == null) {
            throw new ApiException("No room available");
        }

        Map<String, String> arrangement = new LinkedHashMap<>();
        int seat = 1;
        for (Student s : session.getStudents()) {
            arrangement.put("Seat-" + seat++, s.getRollNumber());
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
