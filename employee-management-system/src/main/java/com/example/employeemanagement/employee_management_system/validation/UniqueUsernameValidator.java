package com.example.employeemanagement.employee_management_system.validation;

import com.example.employeemanagement.employee_management_system.repository.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
  private final UserRepository userRepository;

  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {
    if (username == null || username.isEmpty()) {
        return true;
    }

    return !userRepository.existsByUsernameContainingIgnoreCase(username);
  }
}
