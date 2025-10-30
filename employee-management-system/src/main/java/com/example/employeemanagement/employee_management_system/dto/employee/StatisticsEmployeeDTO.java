package com.example.employeemanagement.employee_management_system.dto.employee;

import java.util.List;

public class StatisticsEmployeeDTO {
  private Long totalEmployees;

  private List<DepartmentEmployeeCountDTO> byDepartment;

  // Contructor
  public StatisticsEmployeeDTO() {
  }

  public StatisticsEmployeeDTO(Long totalEmployees, List<DepartmentEmployeeCountDTO> byDepartment) {
    this.totalEmployees = totalEmployees;
    this.byDepartment = byDepartment;
  }

  // Getters and Setters
  public Long getTotalEmployees() {
    return totalEmployees;
  }

  public void setTotalEmployees(Long totalEmployees) {
    this.totalEmployees = totalEmployees;
  }

  public List<DepartmentEmployeeCountDTO> getByDepartment() {
    return byDepartment;
  }

  public void setByDepartment(List<DepartmentEmployeeCountDTO> byDepartment) {
    this.byDepartment = byDepartment;
  }
}
