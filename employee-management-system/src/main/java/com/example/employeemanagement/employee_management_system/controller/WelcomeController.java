package com.example.employeemanagement.employee_management_system.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {

  @GetMapping
  public String welcome(@RequestParam(required = false) String name) {
    String welcome = "Welcome to Employee Management System, " + (name != null ? name : "Guest");

    return welcome;
  }
}
