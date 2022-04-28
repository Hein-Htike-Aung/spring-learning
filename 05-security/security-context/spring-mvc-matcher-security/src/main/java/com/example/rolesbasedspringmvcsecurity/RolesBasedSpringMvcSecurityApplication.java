package com.example.rolesbasedspringmvcsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RolesBasedSpringMvcSecurityApplication {


    // In Web Layer
    // DelegatingFilterProxy.doFilter() renders to FilterChainProxy   // First Filter // Act as a Bridge between Servlet filter and Spring Managed Beans that means between Servlet container and spring application Context
    // FilterChainProxy.doFilterInternal() renders to SecurityFilterChain
    // SecurityFilterChain has 12 Spring Managed Beans filters


    // In Method Layer
    // AOP acts as a filter

    public static void main(String[] args) {
        SpringApplication.run(RolesBasedSpringMvcSecurityApplication.class, args);
    }

}
