package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamRoom;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.service.ExamRoomService;

import java.util.List;

public class ExamRoomServiceImpl implements ExamRoomService {

    private final ExamRoomRepository roomRepository;

    public ExamRoomServiceImpl(ExamRoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public ExamRoom addRoom(ExamRoom room) {

        if (room.getRows() == null || room.getColumns() == null) {
            throw new ApiException("Invalid room");
        }

        if (room.getRows() <= 0 || room.getColumns() <= 0) {
            throw new ApiException("Invalid room");
        }

        if (roomRepository.findByRoomNumber(room.getRoomNumber()).isPresent()) {
            throw new ApiException("Room already exists");
        }

        room.ensureCapacityMatches();
        return roomRepository.save(room);
    }

    @Override
    public List<ExamRoom> getAllRooms() {
        return roomRepository.findAll();
    }
}
