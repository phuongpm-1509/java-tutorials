package com.example.employeemanagement.employee_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.employeemanagement.employee_management_system.dto.user.RegisterUserDTO;
import com.example.employeemanagement.employee_management_system.service.UserService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/register")
  public String registerNew(
    Model model
  ) {
    model.addAttribute("user", new RegisterUserDTO());
    return "register";
  }

  @PostMapping("/register")
  public String register(
    @Valid
    @ModelAttribute("user")
    RegisterUserDTO user,
    BindingResult bindingResult,
    Model model) {
    if (bindingResult.hasErrors()) {
      return "register";
    }
    userService.register(user);

    return "redirect:/login";
  }
}
