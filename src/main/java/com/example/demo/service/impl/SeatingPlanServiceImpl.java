package com.example.demo.service.impl;

import com.example.demo.model.ExamRoom;
import com.example.demo.model.ExamSession;
import com.example.demo.model.SeatingPlan;
import com.example.demo.model.Student;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.repository.SeatingPlanRepository;
import com.example.demo.service.SeatingPlanService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final ExamRoomRepository roomRepository;
    private final SeatingPlanRepository seatingPlanRepository;

    public SeatingPlanServiceImpl(
            ExamRoomRepository roomRepository,
            SeatingPlanRepository seatingPlanRepository) {
        this.roomRepository = roomRepository;
        this.seatingPlanRepository = seatingPlanRepository;
    }

    @Override
    public List<SeatingPlan> generateSeatingPlan(ExamSession session) {

        List<Student> students = session.getStudents();
        List<ExamRoom> rooms = roomRepository.findAll();
        List<SeatingPlan> plans = new ArrayList<>();

        int studentIndex = 0;

        for (ExamRoom room : rooms) {
            int capacity = room.getCapacity();

            for (int i = 0; i < capacity && studentIndex < students.size(); i++) {
                Student student = students.get(studentIndex++);

                SeatingPlan plan = new SeatingPlan();
                plan.setRoomNumber(room.getRoomNumber());
                plan.setRollNumber(student.getRollNumber());

                plans.add(seatingPlanRepository.save(plan));
            }
        }
        return plans;
    }
}
