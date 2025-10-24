package com.example.employeemanagement.employee_management_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.employeemanagement.employee_management_system.service.DepartmentService;
import com.example.employeemanagement.employee_management_system.service.EmployeeService;

import jakarta.validation.Valid;

import com.example.employeemanagement.employee_management_system.dto.employee.CreateEmployeeDTO;
import com.example.employeemanagement.employee_management_system.dto.employee.SearchEmployeeDTO;
import com.example.employeemanagement.employee_management_system.model.Employee;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.employeemanagement.employee_management_system.model.Department;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  private final EmployeeService employeeService;
  private final DepartmentService departmentService;
  private final ModelMapper modelMapper;

  public EmployeeController(EmployeeService employeeService, DepartmentService departmentService, ModelMapper modelMapper) {
    this.employeeService = employeeService;
    this.departmentService = departmentService;
    this.modelMapper = modelMapper;
  }

  @GetMapping
  public String listEmployee(
    @RequestParam(required = false) String name,
    @RequestParam(required = false) Long departmentId,
    Model model
  ) {
    SearchEmployeeDTO params = new SearchEmployeeDTO(name, departmentId);
    List<Department> departments = departmentService.getAllDepartments();
    List<Employee> employees = employeeService.getAllEmployees(name, departmentId);
    model.addAttribute("departments", departments);
    model.addAttribute("employees", employees);
    model.addAttribute("params", params);

    return "employees/index";
  }

  @GetMapping("/{id}")
  public String getEmployee(
    @PathVariable
    Long id,
    Model model
  ) {
    Employee employee = employeeService.getEmployeeById(id);
    model.addAttribute("employee", employee);
    return "employees/detail";
  }

  @GetMapping("/new")
  public String newEmployee(Model model) {
    List<Department> departments = departmentService.getAllDepartments();
    model.addAttribute("departments", departments);
    model.addAttribute("employee", new CreateEmployeeDTO());
    return "employees/new";
  }

  @PostMapping("/new")
  public String createEmployee(
    @Valid
    @ModelAttribute("employee")
    CreateEmployeeDTO employee,
    BindingResult bindingResult,
    Model model
  ) {
    if (bindingResult.hasErrors()) {
      List<Department> departments = departmentService.getAllDepartments();
      model.addAttribute("departments", departments);
      return "employees/new";
    }
    employeeService.createEmployee(employee);

    return "redirect:/employees";
  }

  @GetMapping("/{id}/edit")
  public String editEmployee(Model model, @PathVariable Long id) {
    List<Department> departments = departmentService.getAllDepartments();
    Employee employee = employeeService.getEmployeeById(id);

    CreateEmployeeDTO employeeDTO = modelMapper.map(employee, CreateEmployeeDTO.class);
    employeeDTO.setDepartmentId(employee.getDepartment().getId());

    model.addAttribute("departments", departments);
    model.addAttribute("employee", employeeDTO);
    model.addAttribute("employeeId", id);
    return "employees/edit";
  }

  @PostMapping("/{id}/edit")
  public String updateEmployee(
    @PathVariable
    Long id,
    @Valid
    @ModelAttribute("employee")
    CreateEmployeeDTO employee,
    BindingResult bindingResult,
    Model model
  ) {
    if (bindingResult.hasErrors()) {
      List<Department> departments = departmentService.getAllDepartments();
      model.addAttribute("departments", departments);
      model.addAttribute("employeeId", id);

      return "employees/edit";
    }
    employeeService.updateEmployee(id, employee);

    return "redirect:/employees";
  }

  @GetMapping("{id}/delete")
  public String deleteEmployee(
    @PathVariable
    Long id
  ) {
    employeeService.deleteEmployee(id);
    return "redirect:/employees";
  }
}
