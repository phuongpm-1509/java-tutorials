package com.example.employeemanagement.employee_management_system.dto.employee;

public class EmployeeCount {

    private Long totalEmployees;

    // Constructors
    public EmployeeCount() {}

    public EmployeeCount(Long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    // Getters and Setters
    public Long getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(Long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }
}
