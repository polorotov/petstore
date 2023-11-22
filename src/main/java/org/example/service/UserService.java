package org.example.service;

import org.example.dto.User;
import org.example.dto.request.UserRequest;

import java.util.List;

public interface UserService {
    List<User> getList();

    User getUser(Integer id);

    User createUser(UserRequest userRequest);

    User editUser(Integer id, UserRequest userRequest);

    void destroyUser(Integer id);

    boolean checkPassword(String email, String password);
}
