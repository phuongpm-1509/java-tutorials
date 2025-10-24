package com.example.employeemanagement.employee_management_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.employeemanagement.employee_management_system.service.EmployeeService;
import com.example.employeemanagement.employee_management_system.model.Employee;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
      this.employeeService = employeeService;
  }

  @GetMapping
  public List<Employee> listEmployee() {
      return employeeService.getAllEmployees();
  }

  @PostMapping("/create")
  public Employee createEmployee(@RequestBody Employee employee) {
      return employeeService.createEmployee(employee);
  }
}
