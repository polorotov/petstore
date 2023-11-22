package org.example.service.impl;

import org.example.jpa.entity.TokenTab;
import org.example.jpa.repository.TokenRepository;
import org.example.service.TokenService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public String getToken() {
        TokenTab tokenTab = new TokenTab();
        String token = UUID.randomUUID().toString();
        Instant expire = LocalDateTime.now().toInstant(ZoneOffset.UTC).plusSeconds(3600);
        tokenTab.setToken(token);
        tokenTab.setExpire(expire);
        tokenRepository.save(tokenTab);
        return token;
    }

    @Override
    public void removeExpiredTokens() {
        Instant now = Instant.now();
        tokenRepository.deleteExpiredTokens(now);
    }
}
