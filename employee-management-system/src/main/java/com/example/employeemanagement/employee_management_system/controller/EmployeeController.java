package com.example.employeemanagement.employee_management_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.employeemanagement.employee_management_system.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import com.example.employeemanagement.employee_management_system.dto.employee.CreateEmployeeDTO;
import com.example.employeemanagement.employee_management_system.model.Employee;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping
  public List<Employee> listEmployee(
    @RequestParam(required = false) String name,
    @RequestParam(required = false) Long departmentId
  ) {
    return employeeService.getAllEmployees(name, departmentId);
  }

  @GetMapping("/{id}")
  public Employee getEmployee(
    @PathVariable
    Long id
  ) {
    return employeeService.getEmployeeById(id);
  }

  @PostMapping("/create")
  public Employee createEmployee(
    @Valid
    @RequestBody
    CreateEmployeeDTO employee
  ) {
    return employeeService.createEmployee(employee);
  }

  @PatchMapping("/{id}/update")
  public Employee updateEmployee(
    @PathVariable
    Long id,
    @Valid
    @RequestBody
    CreateEmployeeDTO employee
  ) {
    return employeeService.updateEmployee(id, employee);
  }

  @DeleteMapping("/{id}")
  public boolean deleteEmployee(
    @PathVariable
    Long id
  ) {
    return employeeService.deleteEmployee(id);
  }
}
