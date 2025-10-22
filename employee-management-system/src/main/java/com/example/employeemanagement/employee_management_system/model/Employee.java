package com.example.employeemanagement.employee_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "employees")
public class Employee {
  // Declare column
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "department_id", nullable = false)
  private Department department;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = true, unique = true)
  private String code;

  // Constructor
  public Employee() {
  }

  public Employee(String name, Department department, String email, String code) {
    this.name = name;
    this.department = department;
    this.email = email;
    this.code = code;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Department getDepartment() {
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

  public void setDepartment(Department department) {
    this.department = department;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
