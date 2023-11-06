package org.example.service;

import org.example.dto.Pet;
import org.example.dto.PetSimple;
import org.example.dto.request.PetRequest;

import java.util.List;

public interface PetService {
    List<PetSimple> getList();
    Pet getPet(Integer id);
    Pet createPet(PetRequest petRequest);
    Pet editPet(Integer id, PetRequest petRequest);
    void destroyPet(Integer id);
}
