package com.example.employeemanagement.employee_management_system.service;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UtilityService {
  public String capitalizeWords(String text) {
    return Arrays.stream(text.trim().split("\\s+"))
        .map(t -> t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase())
        .collect(Collectors.joining(" "));
  }

  public String generateEmployeeCode(String prefix, Long id) {
    return prefix.toUpperCase() + "-" + String.format("%04d", id);
  }
}
