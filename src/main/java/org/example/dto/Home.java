package org.example.dto;

import lombok.Builder;
import lombok.Data;
import org.example.dto.request.HomeRequest;
import org.example.jpa.entity.HomeTab;
import org.example.jpa.entity.PetTab;

@Data
@Builder
public class Home {
    private Integer id;
    private String name;
    private String address;

    public void create(HomeRequest homeRequest, Integer id) {
        this.id = id;
        this.set(homeRequest);
    }

    public static Home get(HomeTab homeTab){
        return Home.builder()
                .id(homeTab.getId())
                .name(homeTab.getName())
                .address(homeTab.getAddress())
                .build();
    }

    private void set(HomeRequest homeRequest) {
        this.name = homeRequest.getName();
        this.address = homeRequest.getAddress();
    }
}