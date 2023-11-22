package org.example.service.impl;

import org.example.dto.Room;
import org.example.dto.request.RoomRequest;
import org.example.jpa.entity.RoomTab;
import org.example.jpa.repository.RoomRepository;
import org.example.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    @Override
    public Room createRoom(RoomRequest roomRequest) {
        RoomTab roomTab = new RoomTab();
        this.save(roomTab, roomRequest);
        return Room.get(roomTab);
    }

    public Room editRoom(Integer id, RoomRequest roomRequest) {
        RoomTab roomTab = roomRepository.findById(id).orElse(null);
        assert roomTab != null;
        this.save(roomTab, roomRequest);
        return Room.get(roomTab);
    }

    @Override
    public List<Room> getList() {
        List<RoomTab> roomTabs = roomRepository.findAll();
        List<Room> rooms = new ArrayList<>();
        for (RoomTab roomTab : roomTabs) {
            Room room = Room.get(roomTab);
            rooms.add(room);
        }
        return rooms;
    }

    @Override
    public Room getRoom(Integer id) {
        RoomTab roomTab = roomRepository.findById(id).orElse(null);
        assert roomTab != null;
        return Room.get(roomTab);
    }

    @Override
    public void destroyRoom(Integer id) {
        RoomTab roomTab = roomRepository.findById(id).orElse(null);
        assert roomTab != null;
        roomRepository.delete(roomTab);
    }

    private void save(RoomTab roomTab, RoomRequest roomRequest) {
        roomTab.setName(roomRequest.getName());
        roomRepository.save(roomTab);
    }
}
