package com.example.employeemanagement.employee_management_system.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Component
public class SystemMonitorTask {
  private static final Logger logger = LoggerFactory.getLogger(SystemMonitorTask.class);

  @Scheduled(fixedRate = 10000)
  public void monitorSystemHealth() {
    logger.info("System running");
    System.out.println("System running");
  }
}
