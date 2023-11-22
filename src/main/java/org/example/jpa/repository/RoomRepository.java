package org.example.jpa.repository;

import org.example.jpa.entity.RoomTab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomTab, Integer> {
    RoomTab findByName(String name);
}
