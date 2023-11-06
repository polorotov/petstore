package org.example.dto;

import lombok.Data;

@Data
public class PetSimple {
    private Integer id;
    private String name;

    public void create(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}