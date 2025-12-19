package com.example.demo.controller;

import com.example.demo.model.SeatingPlan;
import com.example.demo.service.SeatingPlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class SeatingPlanController {

    private final SeatingPlanService seatingPlanService;

    @Autowired
    public SeatingPlanController(SeatingPlanService seatingPlanService) {
        this.seatingPlanService = seatingPlanService;
    }

    @PostMapping("/generate/{sessionId}")
    public SeatingPlan generatePlan(@PathVariable Long sessionId) {
        return seatingPlanService.generatePlan(sessionId);
    }

    @GetMapping("/{planId}")
    public SeatingPlan getPlan(@PathVariable Long planId) {
        return seatingPlanService.getPlan(planId);
    }

    @GetMapping("/session/{sessionId}")
    public List<SeatingPlan> getPlansBySession(@PathVariable Long sessionId) {
        return seatingPlanService.getPlansBySession(sessionId);
    }
}
