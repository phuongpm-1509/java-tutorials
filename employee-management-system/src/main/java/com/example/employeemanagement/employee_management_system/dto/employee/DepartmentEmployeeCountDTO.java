package com.example.employeemanagement.employee_management_system.dto.employee;

import lombok.Value;

@Value
public class DepartmentEmployeeCountDTO {
  private Long departmentId;
  private String departmentName;
  private Long totalCount;
}
