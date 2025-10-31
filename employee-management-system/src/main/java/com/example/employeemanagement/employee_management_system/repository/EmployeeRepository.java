package com.example.employeemanagement.employee_management_system.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employeemanagement.employee_management_system.dto.employee.DepartmentEmployeeCountDTO;
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

  @Query("SELECT d.id AS departmentId, d.name AS departmentName, COUNT(e.id) AS totalCount " +
          "FROM " +
              "Department d " +
          "LEFT JOIN " +
              "d.employees e " +
          "GROUP BY " +
              "d.id, d.name " +
          "ORDER BY " +
              "d.id")
  List<DepartmentEmployeeCountDTO> getStatisticsEmployeeCount();
}
