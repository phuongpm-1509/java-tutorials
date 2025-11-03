package com.example.employeemanagement.employee_management_system.constaints;

import java.util.List;

public final class UIConstants {
  private UIConstants() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  public static final List<String> BG_COLORS = List.of(
    "bg-primary", "bg-secondary", "bg-success", "bg-danger",
    "bg-warning", "bg-info", "bg-light", "bg-dark", "bg-white"
  );
}
