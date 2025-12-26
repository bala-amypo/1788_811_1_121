package com.example.demo.controller;

import com.example.demo.model.ExamSession;
import com.example.demo.model.SeatingPlan;
import com.example.demo.service.ExamSessionService;
import com.example.demo.service.SeatingPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seating-plans")
public class SeatingPlanController {

    private final SeatingPlanService planService;
    private final ExamSessionService sessionService;

    public SeatingPlanController(
            SeatingPlanService planService,
            ExamSessionService sessionService) {
        this.planService = planService;
        this.sessionService = sessionService;
    }

    // generate seating plan
    @PostMapping("/generate/{sessionId}")
    public List<SeatingPlan> generate(@PathVariable Long sessionId) {
        ExamSession session = sessionService.getSession(sessionId);
        return planService.generateSeatingPlan(session);
    }

    // get single seating plan
    @GetMapping("/{id}")
    public SeatingPlan getPlan(@PathVariable Long id) {
        return planService.getPlan(id);
    }

    // get all plans for a session
    @GetMapping("/session/{sessionId}")
    public List<SeatingPlan> getPlansBySession(@PathVariable Long sessionId) {
        return planService.getPlansBySession(sessionId);
    }
}
