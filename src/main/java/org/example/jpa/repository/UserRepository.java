package org.example.jpa.repository;

import org.example.jpa.entity.UserTab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTab, Integer> {
    UserTab findByEmail(String email);
}
