package com.example.employeemanagement.employee_management_system.service;

import org.springframework.stereotype.Service;

@Service
public class UtilityService {
  public String formatEmployeeName(String name) {
    return name.trim().toUpperCase();
  }

  public String generateEmployeeCode(String prefix, int id) {
    return prefix.toLowerCase() + "-" + String.format("%04d", id);
  }
}
