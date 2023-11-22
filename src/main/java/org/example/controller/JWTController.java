package org.example.controller;

import org.example.service.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home-service")
public class JWTController {

    private final JwtService jwtService;

    public JWTController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/jwt")
    public String generateJwt(@RequestParam String name) {
        return jwtService.generateJwt(name);
    }
}