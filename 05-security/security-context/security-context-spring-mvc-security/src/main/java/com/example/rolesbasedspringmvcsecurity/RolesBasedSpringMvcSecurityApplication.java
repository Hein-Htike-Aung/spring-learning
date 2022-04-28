package com.example.rolesbasedspringmvcsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RolesBasedSpringMvcSecurityApplication {


    // In Web Layer
    // DelegatingFilterProxy.doFilter    // First Filter // Act as a Bridge between spring filter and Spring Managed Beans that means between Servlet container and spring application Context
    // Spring Context has 12 filters which is situated in SecurityFilterChain
    // FilterChainProxy.doFilterInternal() render to SecurityFilterChain

    // In Method Layer
    // AOP act as a filter

    public static void main(String[] args) {
        SpringApplication.run(RolesBasedSpringMvcSecurityApplication.class, args);
    }

}
