package org.example.service.impl;

import org.example.dto.User;
import org.example.dto.request.UserRequest;
import org.example.jpa.entity.UserTab;
import org.example.jpa.repository.UserRepository;
import org.example.service.UserService;
import org.example.util.PasswordUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserRequest userRequest) {
        UserTab userTab = new UserTab();
        this.save(userTab, userRequest);
        return User.get(userTab);
    }

    public User editUser(Integer id, UserRequest userRequest) {
        UserTab userTab = userRepository.findById(id).orElse(null);
        assert userTab != null;
        this.save(userTab, userRequest);
        return User.get(userTab);
    }

    @Override
    public List<User> getList() {
        List<UserTab> userTabs = userRepository.findAll();
        List<User> users = new ArrayList<>();
        for (UserTab userTab : userTabs) {
            User user = User.get(userTab);
            users.add(user);
        }
        return users;
    }

    @Override
    public User getUser(Integer id) {
        UserTab userTab = userRepository.findById(id).orElse(null);
        assert userTab != null;
        return User.get(userTab);
    }

    @Override
    public void destroyUser(Integer id) {
        UserTab userTab = userRepository.findById(id).orElse(null);
        assert userTab != null;
        userRepository.delete(userTab);
    }

    @Override
    public boolean checkPassword(String email, String password) {
        UserTab userTab = userRepository.findByEmail(email);
        return PasswordUtil.checkPassword(password, userTab.getPassword());
    }

    private void save(UserTab userTab, UserRequest userRequest) {
        String hashedPassword = PasswordUtil.hashPassword(userRequest.getPassword());
        userTab.setEmail(userRequest.getEmail());
        userTab.setPassword(hashedPassword);
        userRepository.save(userTab);
    }
}
