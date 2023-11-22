package org.example.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.example.service.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.tokenTtl}")
    private Long ttl;

    @Override
    public String generateJwt(String name) {
        return JWT.create()
                .withClaim("username", name)
                .withExpiresAt(LocalDateTime.now().toInstant(ZoneOffset.UTC).plusSeconds(ttl))
                .sign(Algorithm.HMAC256(secret));
    }
}
