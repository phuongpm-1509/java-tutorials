package com.example.employeemanagement.employee_management_system.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.employeemanagement.employee_management_system.model.Department;
import com.example.employeemanagement.employee_management_system.repository.DepartmentRepository;

@Service
public class DepartmentService {
  private final DepartmentRepository departmentRepository;

  public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
      this.departmentRepository = departmentRepository;
  }

  public List<Department> getAllDepartments() {
    return departmentRepository.findAll();
  }
}
