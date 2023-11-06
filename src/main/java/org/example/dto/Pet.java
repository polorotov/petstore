package org.example.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.dto.request.PetRequest;

@Data
public class Pet {
    private Integer id;
    private String name;
    private Integer age;
    private String type;
    private Integer cost;

    public void create(PetRequest petRequest, Integer id) {
        this.id = id;
        this.set(petRequest);
    }

    public void update(PetRequest petRequest) {
        this.set(petRequest);
    }

    private void set(PetRequest petRequest) {
        this.name = petRequest.getName();
        this.age = petRequest.getAge();
        this.type = petRequest.getType();
        this.cost = petRequest.getCost();
    }
}