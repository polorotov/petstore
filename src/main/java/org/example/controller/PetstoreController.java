package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.Pet;
import org.example.dto.PetSimple;
import org.example.dto.request.PetRequest;
import org.example.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/petstore")
public class PetstoreController {

    private final PetService petService;

    public PetstoreController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping("/get")
    public List<PetSimple> getPets() {
        return this.petService.getList();
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable Integer id) {
        Pet pet = this.petService.getPet(id);
        return ResponseEntity.ok(pet);
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody @Valid PetRequest request) {
        Pet pet = this.petService.createPet(request);
        return ResponseEntity.ok(pet);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pet> editPet(@PathVariable Integer id, @RequestBody @Valid PetRequest request) {
        Pet pet = this.petService.editPet(id, request);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping("{id}")
    public void deletePet(@PathVariable Integer id) {
        this.petService.destroyPet(id);
    }
}