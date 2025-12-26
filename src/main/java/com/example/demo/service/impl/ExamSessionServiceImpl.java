package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamSession;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.ExamSessionService;

import java.time.LocalDate;
@service
public class ExamSessionServiceImpl implements ExamSessionService {

    private final ExamSessionRepository sessionRepository;
    private final StudentRepository studentRepository;

    public ExamSessionServiceImpl(ExamSessionRepository sessionRepository,
                                  StudentRepository studentRepository) {
        this.sessionRepository = sessionRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public ExamSession createSession(ExamSession session) {

        if (session.getExamDate().isBefore(LocalDate.now())) {
            throw new ApiException("Exam date is in the past");
        }

        if (session.getStudents() == null || session.getStudents().isEmpty()) {
            throw new ApiException("At least 1 student required");
        }

        return sessionRepository.save(session);
    }

    @Override
    public ExamSession getSession(Long id) {
        return sessionRepository.findById(id)
                .orElseThrow(() -> new ApiException("Session not found"));
    }
}
