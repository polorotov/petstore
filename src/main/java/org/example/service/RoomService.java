package org.example.service;

import org.example.dto.Room;
import org.example.dto.request.RoomRequest;

import java.util.List;

public interface RoomService {
    List<Room> getList();
    Room getRoom(Integer id);
    Room createRoom(RoomRequest roomRequest);
    Room editRoom(Integer id, RoomRequest roomRequest);
    void destroyRoom(Integer id);
}
