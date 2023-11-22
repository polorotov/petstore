package org.example.dto;

import lombok.Builder;
import lombok.Data;
import org.example.dto.request.RoomRequest;
import org.example.jpa.entity.RoomTab;

@Data
@Builder
public class Room {
    private Integer id;
    private String name;

    public void create(RoomRequest roomRequest) {
        this.set(roomRequest);
    }

    public void update(RoomRequest roomRequest) {
        this.set(roomRequest);
    }

    public static Room get(RoomTab roomTab){
        return Room.builder()
                .id(roomTab.getId())
                .name(roomTab.getName())
                .build();
    }

    private void set(RoomRequest roomRequest) {
        this.name = roomRequest.getName();
    }
}