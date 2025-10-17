package com.example.spring_jpa_core.dto.author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateAuthorDTO {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be less than or equal to 100 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
