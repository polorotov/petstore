package org.example.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class PetRequest {
    @NotBlank
    @Length(min = 3, max = 30)
    private String name;
    @NotNull
    @Min(0)
    @Max(30)
    private Integer age;
    @NotBlank
    @Length(min = 3, max = 30)
    private String type;
    @NotNull
    @Min(0)
    @Max(10000000)
    private Integer cost;
}
