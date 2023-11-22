package org.example.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserRequest {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min = 3, max = 30)
    private String password;
}
