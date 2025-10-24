package com.example.employeemanagement.employee_management_system.dto.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateEmployeeDTO {
  @NotBlank(message= "Name is required")
  @Size(max = 30, message = "Name must be less than 30 characters")
  private String name;

  @NotNull(message= "Department ID is required")
  private Long departmentId;

  @NotBlank(message= "Email is required")
  @Size(max = 250, message = "Email must be less than 250 characters")
  @Email(message = "Email không đúng định dạng")
  private String email;

  // Getters
  public String getName() {
    return name;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public String getEmail() {
    return email;
  }

  // Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
