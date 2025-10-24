package com.example.employeemanagement.employee_management_system.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAspect {

  private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
  private final ObjectMapper objectMapper = new ObjectMapper();

  @AfterReturning(pointcut = "@annotation(com.example.employeemanagement.employee_management_system.annotation.Loggable)",
                  returning = "result")
  public void logAction(JoinPoint joinPoint, Object result) {
    try {
      String className = joinPoint.getTarget().getClass().getSimpleName();
      String methodName = joinPoint.getSignature().getName();
      Object[] args = joinPoint.getArgs();
      String argsJson = objectMapper.writeValueAsString(args);
      String resultJson = objectMapper.writeValueAsString(result);

      logger.info("Function: class={}.method={}", className, methodName);
      logger.info("Args: {}", argsJson);
      logger.info("Result: {}", resultJson);
    } catch (Exception e) {
        logger.error("LoggingAspect failed to log action", e);
    }
  }
}
