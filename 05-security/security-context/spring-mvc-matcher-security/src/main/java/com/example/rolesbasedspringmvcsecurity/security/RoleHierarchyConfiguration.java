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

                        // Using Url Security

                        // ADMINS
                        .append(SUPER_ADMIN, CUSTOMERS_ADMIN)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_PAG_VIEW)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_VIEW)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_CREATE)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_DELETE)

                        .append(SUPER_ADMIN, DEPARTMENTS_ADMIN)
                        .append(DEPARTMENTS_ADMIN, DEPARTMENTS_PAG_VIEW)
                        .append(DEPARTMENTS_ADMIN, DEPARTMENTS_VIEW)
                        .append(DEPARTMENTS_ADMIN, DEPARTMENTS_CREATE)
                        .append(DEPARTMENTS_ADMIN, DEPARTMENTS_DELETE)

                        .append(SUPER_ADMIN, EMPLOYEES_ADMIN)
                        .append(EMPLOYEES_ADMIN, EMPLOYEES_PAG_VIEW)
                        .append(EMPLOYEES_ADMIN, EMPLOYEES_VIEW)
                        .append(EMPLOYEES_ADMIN, EMPLOYEES_CREATE)
                        .append(EMPLOYEES_ADMIN, EMPLOYEES_DELETE)

                        // ALL_VIEWS, ALL_CREATES, ALL_DELETES
                        .append(SUPER_ADMIN, ALL_VIEWS)
                        .append(SUPER_ADMIN, ALL_CREATES)
                        .append(SUPER_ADMIN, ALL_DELETES)

                        // Can witnesss List & Details Info
                        .append(ALL_VIEWS, CUSTOMERS_PAG_VIEW)
                        .append(ALL_VIEWS, DEPARTMENTS_PAG_VIEW)
                        .append(ALL_VIEWS, EMPLOYEES_PAG_VIEW)
                        .append(ALL_VIEWS, CUSTOMERS_VIEW)
                        .append(ALL_VIEWS, DEPARTMENTS_VIEW)
                        .append(ALL_VIEWS, EMPLOYEES_VIEW)

                        // Can witnesss List & Details Info + Create
                        .append(ALL_CREATES, CUSTOMERS_PAG_VIEW)
                        .append(ALL_CREATES, DEPARTMENTS_PAG_VIEW)
                        .append(ALL_CREATES, EMPLOYEES_PAG_VIEW)
                        .append(ALL_CREATES, CUSTOMERS_VIEW)
                        .append(ALL_CREATES, DEPARTMENTS_VIEW)
                        .append(ALL_CREATES, EMPLOYEES_VIEW)
                        .append(ALL_CREATES, CUSTOMERS_CREATE)
                        .append(ALL_CREATES, DEPARTMENTS_CREATE)
                        .append(ALL_CREATES, EMPLOYEES_CREATE)

                        // Can witnesss List & Details Info + Delete
                        .append(ALL_DELETES, CUSTOMERS_PAG_VIEW)
                        .append(ALL_DELETES, DEPARTMENTS_PAG_VIEW)
                        .append(ALL_DELETES, EMPLOYEES_PAG_VIEW)
                        .append(ALL_DELETES, CUSTOMERS_VIEW)
                        .append(ALL_DELETES, DEPARTMENTS_VIEW)
                        .append(ALL_DELETES, EMPLOYEES_VIEW)
                        .append(ALL_DELETES, CUSTOMERS_DELETE)
                        .append(ALL_DELETES, DEPARTMENTS_DELETE)
                        .append(ALL_DELETES, EMPLOYEES_DELETE)

                        .build()

        );
        return roleHierarchy;
    }
}
