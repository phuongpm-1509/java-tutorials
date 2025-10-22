package com.example.employeemanagement.employee_management_system.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.employeemanagement.employee_management_system.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  @Query("SELECT e FROM Employee e WHERE " +
           "(:name IS NULL OR :name = '' OR LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
           "(:departmentId IS NULL OR e.department.id = :departmentId)")
  List<Employee> searchEmployees(
      @Param("name") String name,
      @Param("departmentId") Long departmentId
  );
}
