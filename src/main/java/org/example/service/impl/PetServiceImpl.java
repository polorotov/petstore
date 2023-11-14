package org.example.service.impl;

import org.example.dto.Pet;
import org.example.dto.request.PetRequest;
import org.example.jpa.entity.PetTab;
import org.example.jpa.repository.PetRepository;
import org.example.service.PetService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet createPet(PetRequest petRequest) {
        PetTab petTab = new PetTab();
        this.save(petTab, petRequest);
        return Pet.get(petTab);
    }

    @Override
    public Pet editPet(Integer id, PetRequest petRequest) {
        PetTab petTab = petRepository.findById(id).orElse(null);
        assert petTab != null;
        this.save(petTab, petRequest);
        petRepository.save(petTab);
        return Pet.get(petTab);
    }

    @Override
    public Pet getPet(Integer id) {
        PetTab petTab = petRepository.findById(id).orElse(null);
        assert petTab != null;
        return Pet.get(petTab);
    }

    @Override
    public Pet getPet(String name) {
        PetTab petTab = petRepository.findByName(name);
        assert petTab != null;
        return Pet.get(petTab);
    }

    @Override
    public List<Pet> getList() {
        List<PetTab> petTabs = petRepository.findAll();
        List<Pet> pets = new ArrayList<>();
        for (PetTab petTab : petTabs) {
            Pet pet = Pet.get(petTab);
            pets.add(pet);
        }
        return pets;
    }

    @Override
    public void destroyPet(Integer id) {
        PetTab petTab = petRepository.findById(id).orElse(null);
        assert petTab != null;
        petRepository.delete(petTab);
    }

    private void save(PetTab petTab, PetRequest petRequest) {
        petTab.setAge(petRequest.getAge());
        petTab.setCost(petRequest.getCost());
        petTab.setName(petRequest.getName());
        petTab.setType(petRequest.getType());
        petRepository.save(petTab);
    }
}
