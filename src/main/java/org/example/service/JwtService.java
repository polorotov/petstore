package org.example.service;

import org.example.dto.Room;
import org.example.dto.request.RoomRequest;

import java.util.List;

public interface JwtService {
    String generateJwt(String name);
}
