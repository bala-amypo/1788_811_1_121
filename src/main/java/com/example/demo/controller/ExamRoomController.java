package com.example.demo.controller;

import com.example.demo.model.ExamRoom;
import com.example.demo.service.ExamRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class ExamRoomController {

    private final ExamRoomService roomService;

    public ExamRoomController(ExamRoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ExamRoom addRoom(@RequestBody ExamRoom room) {
        return roomService.addRoom(room);
    }

    @GetMapping
    public List<ExamRoom> getAllRooms() {
        return roomService.getAllRooms();
    }
}
