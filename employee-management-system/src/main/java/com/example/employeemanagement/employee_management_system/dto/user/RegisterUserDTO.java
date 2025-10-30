package com.example.employeemanagement.employee_management_system.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterUserDTO {
  @NotBlank(message= "Username is required")
  @Size(max = 30, message = "Username must be less than 30 characters")
  private String username;

  @NotBlank(message= "Password is required")
  @Size(min = 5, max = 8, message = "Pass must be between 5 and 8 characters")
  private String password;

  // Contructor
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
