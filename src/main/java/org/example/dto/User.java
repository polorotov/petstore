package org.example.dto;

import lombok.Builder;
import lombok.Data;
import org.example.dto.request.UserRequest;
import org.example.jpa.entity.UserTab;

@Data
@Builder
public class User {
    private Integer id;
    private String email;
    private String password;

    public void create(UserRequest userRequest) {
        this.set(userRequest);
    }

    public static User get(UserTab userTab){
        return User.builder()
                .id(userTab.getId())
                .email(userTab.getEmail())
                .password(userTab.getPassword())
                .build();
    }

    private void set(UserRequest userRequest) {
        this.email = userRequest.getEmail();
        this.password = userRequest.getPassword();
    }
}