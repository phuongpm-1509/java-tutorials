package com.example.employeemanagement.employee_management_system.dto.user;

import com.example.employeemanagement.employee_management_system.validation.UniqueUsername;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDTO {
  @NotBlank(message= "Username is required")
  @Size(max = 30, message = "Username must be less than 30 characters")
  @UniqueUsername
  private String username;

  @NotBlank(message= "Password is required")
  @Size(min = 5, max = 8, message = "Pass must be between 5 and 8 characters")
  private String password;
}
