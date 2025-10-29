package com.example.employeemanagement.employee_management_system.dto.user;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterUserDTO {
  @NotBlank(message= "Username is required")
  @Size(max = 10, message = "Username must be less than 10 characters")
  private String username;

  @NotBlank(message= "Password is required")
  // @Min(value = 5, message = "Pass must be less than 5 characters")
  private String password;

  public RegisterUserDTO() {}

  public RegisterUserDTO(String username, String password) {
    this.username = username;
    this.password = password;
  }

  // Getters
  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  // Setters
  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
