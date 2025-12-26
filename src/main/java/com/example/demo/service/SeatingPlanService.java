package com.example.demo.service;

import com.example.demo.model.ExamSession;
import com.example.demo.model.SeatingPlan;

import java.util.List;

public interface SeatingPlanService {

    // generate seating plan
    List<SeatingPlan> generateSeatingPlan(ExamSession session);

    // get single plan by id
    SeatingPlan getPlan(Long id);

    // get all plans for a session
    List<SeatingPlan> getPlansBySession(Long sessionId);
}
