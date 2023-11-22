package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.Room;
import org.example.dto.request.RoomRequest;
import org.example.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room-service")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/get")
    public List<Room> getRooms() {
        return this.roomService.getList();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable Integer id) {
        Room room = this.roomService.getRoom(id);
        return ResponseEntity.ok(room);
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody @Valid RoomRequest request) {
        Room room = this.roomService.createRoom(request);
        return ResponseEntity.ok(room);
    }

    @PutMapping("{id}")
    public ResponseEntity<Room> editRoom(@PathVariable Integer id, @RequestBody @Valid RoomRequest request) {
        Room room = this.roomService.editRoom(id, request);
        return ResponseEntity.ok(room);
    }

    @DeleteMapping("{id}")
    public void deleteRoom(@PathVariable Integer id) {
        this.roomService.destroyRoom(id);
    }
}
