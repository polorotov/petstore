package org.example.jpa.repository;

import org.example.jpa.entity.HomeTab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<HomeTab, Integer> {
    HomeTab findByName(String name);
}
