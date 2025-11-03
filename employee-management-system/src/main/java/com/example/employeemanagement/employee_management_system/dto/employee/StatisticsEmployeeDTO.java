package com.example.employeemanagement.employee_management_system.dto.employee;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsEmployeeDTO {
  private Long totalEmployees;
  private List<DepartmentEmployeeCountDTO> byDepartment;
}
