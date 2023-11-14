package org.example.jpa.repository;

import org.example.jpa.entity.PetTab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<PetTab, Integer> {
    PetTab findByName(String name);
}
