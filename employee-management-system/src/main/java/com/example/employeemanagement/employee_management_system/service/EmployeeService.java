package com.example.employeemanagement.employee_management_system.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.example.employeemanagement.employee_management_system.model.Employee;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {
  private static final List<Employee> EMPLOYEE_STORE = new ArrayList<>();
  private static final AtomicLong ID_COUNTER = new AtomicLong(1);
  private final UtilityService utilityService;

  static {
    EMPLOYEE_STORE.add(new Employee(ID_COUNTER.getAndIncrement(), "Nguyen Van A","Phòng hành chính", "nguyen.van.a@gmail.com" , "EMP-0001"));
    EMPLOYEE_STORE.add(new Employee(ID_COUNTER.getAndIncrement(), "Nguyen Van B", "Phòng nhân sự", "nguyen.van.b@gmail.com" , "EMP-0002"));
  }

  public EmployeeService(UtilityService utilityService) {
      this.utilityService = utilityService;
  }

  public List<Employee> getAllEmployees() {
    return EMPLOYEE_STORE;
  }

  public Employee createEmployee(Employee newEmployee) {
    Long id = ID_COUNTER.getAndIncrement();

    newEmployee.setId(id);
    newEmployee.setName(utilityService.capitalizeWords(newEmployee.getName()));
    newEmployee.setCode(utilityService.generateEmployeeCode("EMP", id));

    EMPLOYEE_STORE.add(newEmployee);

    return newEmployee;
  }
}
