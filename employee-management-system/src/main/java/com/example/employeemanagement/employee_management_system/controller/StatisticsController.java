package com.example.employeemanagement.employee_management_system.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.employeemanagement.employee_management_system.dto.employee.StatisticsEmployeeDTO;
import com.example.employeemanagement.employee_management_system.service.StatisticsService;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {

  private final StatisticsService statisticsService;

  public StatisticsController(StatisticsService statisticsService) {
    this.statisticsService = statisticsService;
  }

  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public String statistics(Model model) {
    StatisticsEmployeeDTO statistics = statisticsService.statistics();
    List<String> bgColors = List.of(
        "bg-primary", "bg-secondary", "bg-success", "bg-danger",
        "bg-warning", "bg-info", "bg-light", "bg-dark", "bg-white"
    );

    model.addAttribute("statistics", statistics);
    model.addAttribute("bgColors", bgColors);

    return "statistics/index";
  }
}
