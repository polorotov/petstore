package org.example.jpa.repository;

import org.example.jpa.entity.TokenTab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

public interface TokenRepository extends JpaRepository<TokenTab, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM TokenTab t WHERE t.expire < :cutoff")
    void deleteExpiredTokens(Instant cutoff);
}
