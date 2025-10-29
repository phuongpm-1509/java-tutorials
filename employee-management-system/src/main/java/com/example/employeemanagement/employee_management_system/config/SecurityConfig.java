package com.example.employeemanagement.employee_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
          .authorizeHttpRequests(auth -> auth
              .requestMatchers("/css/**", "/js/**", "/public/**", "/images/**").permitAll()
              .requestMatchers("/register").permitAll()
              .requestMatchers("/api/**").permitAll()  // TODO: Implement module 9
              .requestMatchers("/actuator/**").hasRole("ADMIN")
              .requestMatchers("/employees").hasAnyRole("USER", "ADMIN")
              .requestMatchers("/employees/new").hasAnyRole("ADMIN")
              .requestMatchers("/employees/{id}/edit").hasAnyRole("ADMIN")
              .anyRequest().authenticated()
          )
          .formLogin(form -> form
              .loginPage("/login")
              .defaultSuccessUrl("/employees", true)
              .permitAll()
          )
          .logout(logout -> logout
              .logoutSuccessUrl("/login?logout=true")
              .deleteCookies("JSESSIONID")
              .permitAll()
          )
          .httpBasic(withDefaults());
      return http.build();
  }
}
