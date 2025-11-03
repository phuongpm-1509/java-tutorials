package com.example.employeemanagement.employee_management_system.service;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.employee_management_system.dto.user.RegisterUserDTO;
import com.example.employeemanagement.employee_management_system.model.User;
import com.example.employeemanagement.employee_management_system.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.modelmapper.ModelMapper;
import com.example.employeemanagement.employee_management_system.model.Role;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final ModelMapper modelMapper = new ModelMapper();

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User register(RegisterUserDTO registerUserDTO) {
    User user = modelMapper.map(registerUserDTO, User.class);
    user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
    user.setRole(Role.USER);

    return userRepository.save(user);
  }
}
