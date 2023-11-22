package org.example.service;

public interface TokenService {
    String getToken();
    void removeExpiredTokens();
}
