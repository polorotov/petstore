package org.example.dto;

import lombok.Builder;
import lombok.Data;
import org.example.dto.request.PetRequest;
import org.example.jpa.entity.PetTab;

@Data
@Builder
public class Pet {
    private Integer id;
    private String name;
    private Integer age;
    private String type;
    private Integer cost;

    public void create(PetRequest petRequest) {
        this.set(petRequest);
    }

    public void update(PetRequest petRequest) {
        this.set(petRequest);
    }

    public static Pet get(PetTab petTab){
        return Pet.builder()
                .id(petTab.getId())
                .name(petTab.getName())
                .age(petTab.getAge())
                .type(petTab.getType())
                .cost(petTab.getCost())
                .build();
    }

    private void set(PetRequest petRequest) {
        this.name = petRequest.getName();
        this.age = petRequest.getAge();
        this.type = petRequest.getType();
        this.cost = petRequest.getCost();
    }
}