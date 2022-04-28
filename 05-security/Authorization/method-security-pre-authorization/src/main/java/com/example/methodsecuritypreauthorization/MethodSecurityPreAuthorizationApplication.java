package com.example.methodsecuritypreauthorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MethodSecurityPreAuthorizationApplication {

    // prepost authorization
    // @Secured
    // JSR 250 @RolesAllowed

    public static void main(String[] args) {
        SpringApplication.run(MethodSecurityPreAuthorizationApplication.class, args);
    }

}
