package com.example.demo.controller;

import com.example.demo.model.ExamSession;
import com.example.demo.service.ExamSessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessions")
public class ExamSessionController {

    private final ExamSessionService examSessionService;

    @Autowired
    public ExamSessionController(ExamSessionService examSessionService) {
        this.examSessionService = examSessionService;
    }

    @PostMapping
    public ExamSession createSession(@RequestBody ExamSession session) {
        return examSessionService.createSession(session);
    }

    @GetMapping("/{sessionId}")
    public ExamSession getSession(@PathVariable Long sessionId) {
        return examSessionService.getSession(sessionId);
    }
}
