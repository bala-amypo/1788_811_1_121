package com.example.demo.controller;

import com.example.demo.model.ExamSession;
import com.example.demo.service.ExamSessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class ExamSessionController {

    private final ExamSessionService sessionService;

    public ExamSessionController(ExamSessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public ExamSession createSession(@RequestBody ExamSession session) {
        return sessionService.createSession(session);
    }

    @GetMapping("/{id}")
    public ExamSession getSession(@PathVariable Long id) {
        return sessionService.getSession(id);
    }

    @GetMapping
    public List<ExamSession> getAllSessions() {
        return sessionService.getAllSessions();
    }
}
