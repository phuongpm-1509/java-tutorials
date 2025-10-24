package com.example.employeemanagement.employee_management_system.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.employeemanagement.employee_management_system.annotation.Loggable;
import com.example.employeemanagement.employee_management_system.dto.employee.CreateEmployeeDTO;
import com.example.employeemanagement.employee_management_system.exception.ResourceNotFoundException;
import com.example.employeemanagement.employee_management_system.model.Department;
import com.example.employeemanagement.employee_management_system.model.Employee;
import com.example.employeemanagement.employee_management_system.repository.EmployeeRepository;
import com.example.employeemanagement.employee_management_system.repository.DepartmentRepository;

@Service
public class EmployeeService {
  private final UtilityService utilityService;
  private final DepartmentRepository departmentRepository;
  private final EmployeeRepository employeeRepository;
  private final ModelMapper modelMapper;

  public EmployeeService(UtilityService utilityService, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, ModelMapper modelMapper) {
      this.utilityService = utilityService;
      this.departmentRepository = departmentRepository;
      this.employeeRepository = employeeRepository;
      this.modelMapper = modelMapper;
  }

  public List<Employee> getAllEmployees(String name, Long departmentId) {
    return employeeRepository.searchEmployees(name, departmentId);
  }

  public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id).orElseThrow(
      () -> new ResourceNotFoundException("Employee not found")
    );
  }

  @Loggable
  public Employee createEmployee(CreateEmployeeDTO newEmployeeDTO) {
    Department department = departmentRepository.findById(newEmployeeDTO.getDepartmentId()).orElseThrow(
      () -> new ResourceNotFoundException("Department not found")
    );

    Employee employee = modelMapper.map(newEmployeeDTO, Employee.class);
    employee.setName(utilityService.capitalizeWords(employee.getName()));
    employee.setDepartment(department);

    Employee savedEmployee = employeeRepository.save(employee);
    savedEmployee.setCode(utilityService.generateEmployeeCode("EMP", savedEmployee.getId()));

    return employeeRepository.save(savedEmployee);
  }

  @Loggable
  public Employee updateEmployee(Long id, CreateEmployeeDTO newEmployeeDTO) {
    Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
      () -> new ResourceNotFoundException("Employee not found")
    );
    Department department = departmentRepository.findById(newEmployeeDTO.getDepartmentId()).orElseThrow(
      () -> new ResourceNotFoundException("Department not found")
    );

    modelMapper.map(newEmployeeDTO, existingEmployee);
    existingEmployee.setName(utilityService.capitalizeWords(newEmployeeDTO.getName()));
    existingEmployee.setDepartment(department);

    return employeeRepository.save(existingEmployee);
  }

  @Loggable
  public boolean deleteEmployee(Long id) {
    Employee employee = getEmployeeById(id);

    employeeRepository.deleteById(employee.getId());
    return true;
  }
}
