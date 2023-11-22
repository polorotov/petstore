package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.User;
import org.example.dto.request.UserRequest;
import org.example.service.TokenService;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-service")
public class UserController {

    private final UserService userService;
    private final TokenService tokenService;

    public UserController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @GetMapping("/get")
    public List<User> getUsers() {
        return this.userService.getList();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        User user = this.userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserRequest request) {
        User user = this.userService.createUser(request);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable Integer id, @RequestBody @Valid UserRequest request) {
        User user = this.userService.editUser(id, request);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        this.userService.destroyUser(id);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid UserRequest request) {
        if(this.userService.checkPassword(request.getEmail(), request.getPassword())) {
            return this.tokenService.getToken();
        }

        return "no";
    }
}
