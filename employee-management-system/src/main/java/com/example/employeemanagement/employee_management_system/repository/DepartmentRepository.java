package com.example.employeemanagement.employee_management_system.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employeemanagement.employee_management_system.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
