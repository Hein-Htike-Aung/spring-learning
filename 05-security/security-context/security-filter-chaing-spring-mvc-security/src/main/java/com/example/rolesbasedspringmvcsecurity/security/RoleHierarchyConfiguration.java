package com.example.rolesbasedspringmvcsecurity.security;


import com.example.rolesbasedspringmvcsecurity.security.util.RolesHierarchyBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

import static com.example.rolesbasedspringmvcsecurity.security.SecurityRoles.*;

@Configuration
public class RoleHierarchyConfiguration {


    // Build RoleHierarchy
    @Bean
    public RoleHierarchy roleHierarchy() {

        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy(
                new RolesHierarchyBuilder()
                        .append(SUPER_ADMIN, CUSTOMERS_ADMIN)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_PAG_VIEW)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_CREATE)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_DELETE)

                        .append(SUPER_ADMIN, DEPARTMENTS_ADMIN)
                        .append(DEPARTMENTS_ADMIN, DEPARTMENTS_PAG_VIEW)
                        .append(DEPARTMENTS_ADMIN, DEPARTMENTS_CREATE)
                        .append(DEPARTMENTS_ADMIN, DEPARTMENTS_DELETE)

                        .append(SUPER_ADMIN, EMPLOYEES_ADMIN)
                        .append(EMPLOYEES_ADMIN, EMPLOYEES_PAG_VIEW)
                        .append(EMPLOYEES_ADMIN, EMPLOYEES_CREATE)
                        .append(EMPLOYEES_ADMIN, EMPLOYEES_DELETE)


                        .build()

        );
        return roleHierarchy;
    }
}
