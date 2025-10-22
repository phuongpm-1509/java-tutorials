package com.example.employeemanagement.employee_management_system.dto.employee;

public class CreateEmployeeDTO {
  private String name;

  private Long departmentId;

  private String email;

  public String getName() {
    return name;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public String getEmail() {
    return email;
  }
}
