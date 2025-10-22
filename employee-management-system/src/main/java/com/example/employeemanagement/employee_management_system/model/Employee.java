package com.example.employeemanagement.employee_management_system.model;

public class Employee {
  private Long id;
  private String name;
  private String department;
  private String email;
  private String code;

  public Employee(Long id, String name, String department, String email, String code) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.email = email;
    this.code = code;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDepartment() {
    return department;
  }

  public String getEmail() {
    return email;
  }

  public String getCode() {
    return code;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
