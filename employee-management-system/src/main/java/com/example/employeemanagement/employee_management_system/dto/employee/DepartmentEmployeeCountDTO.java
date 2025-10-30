package com.example.employeemanagement.employee_management_system.dto.employee;

public class DepartmentEmployeeCountDTO {
  private Long departmentId;
  private String departmentName;
  private Long totalCount;

  // Contructor
  public DepartmentEmployeeCountDTO() {
  }

  public DepartmentEmployeeCountDTO(Long departmentId, String departmentName, Long totalCount) {
    this.departmentId = departmentId;
    this.departmentName = departmentName;
    this.totalCount = totalCount;
  }

  // Getters and Setters
  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public Long getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Long totalCount) {
    this.totalCount = totalCount;
  }
}
