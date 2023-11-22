package org.example.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.example.service.TokenService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Slf4j
@Component
public class Scheduler {

    private TokenService tokenService;

    public Scheduler(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Scheduled(fixedDelay = 50000)
    public void revokeToken() {
        this.tokenService.removeExpiredTokens();
    }
}
