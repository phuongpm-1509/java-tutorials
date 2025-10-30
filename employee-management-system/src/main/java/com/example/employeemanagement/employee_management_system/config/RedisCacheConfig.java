package com.example.employeemanagement.employee_management_system.config;

import java.time.Duration;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

@Configuration
public class RedisCacheConfig {

  @Bean
  public RedisCacheManagerBuilderCustomizer myRedisCacheManagerBuilderCustomizer() {
		return (builder) -> builder
			.withCacheConfiguration("employeeCount", RedisCacheConfiguration
				.defaultCacheConfig().entryTtl(Duration.ofMinutes(1)));
	}
}
