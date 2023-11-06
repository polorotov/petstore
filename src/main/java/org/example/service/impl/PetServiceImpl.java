package org.example.service.impl;

import org.example.dto.Pet;
import org.example.dto.PetSimple;
import org.example.dto.request.PetRequest;
import org.example.service.PetService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PetServiceImpl implements PetService {

    private final List<Pet> petList = new ArrayList<>();

    private Integer count = 1;

    @Override
    public Pet createPet(PetRequest petRequest) {
        Pet pet = new Pet();
        pet.create(petRequest, count);
        petList.add(pet);
        count++;
        return pet;
    }

    public Pet editPet(Integer id, PetRequest petRequest) {
        Pet pet = this.getById(id);
        assert pet != null;
        pet.update(petRequest);
        return pet;
    }

    @Override
    public List<PetSimple> getList() {
        List<PetSimple> petSimples = new ArrayList<>();
        for (Pet pet : petList) {
            PetSimple petSimple = new PetSimple();
            petSimple.create(pet.getId(), pet.getName());
            petSimples.add(petSimple);
        }
        return petSimples;
    }

    @Override
    public Pet getPet(Integer id) {
        return this.getById(id);
    }

    @Override
    public void destroyPet(Integer id) {
        Pet pet = this.getById(id);
        petList.remove(pet);
    }

    private Pet getById(Integer id) {
        for (Pet pet : petList) {
            if (Objects.equals(pet.getId(), id)) {
                return pet;
            }
        }
        return null;
    }
}
