package com.example.employeemanagement.employee_management_system.service;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.employee_management_system.dto.employee.DepartmentEmployeeCountDTO;
import com.example.employeemanagement.employee_management_system.dto.employee.StatisticsEmployeeDTO;
import com.example.employeemanagement.employee_management_system.repository.EmployeeRepository;
import java.util.List;

@Service
public class StatisticsService {

  private final EmployeeRepository employeeRepository;

  public StatisticsService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public StatisticsEmployeeDTO statistics() {
    List<DepartmentEmployeeCountDTO> statistics = employeeRepository.getStatisticsEmployeeCount();
    Long totalEmployees = employeeRepository.count();

    return new StatisticsEmployeeDTO(totalEmployees, statistics);
  }
}
