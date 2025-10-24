package com.example.employeemanagement.employee_management_system.dto.employee;

public class SearchEmployeeDTO {
  private String name;
  private Long departmentId;

  // Constructor
  public SearchEmployeeDTO() {
  }

  public SearchEmployeeDTO(String name, Long departmentId) {
    this.name = name;
    this.departmentId = departmentId;
  }

  // Getters
  public String getName() {
    return name;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  // Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }
}
