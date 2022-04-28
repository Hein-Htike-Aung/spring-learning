package com.example.rolesbasedspringmvcsecurity.security.annotations.customers;


import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.example.rolesbasedspringmvcsecurity.security.SecurityRoles.CUSTOMERS_DELETE;
import static com.example.rolesbasedspringmvcsecurity.security.SecurityRoles.ROLE_PREFIX;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Secured(ROLE_PREFIX + CUSTOMERS_DELETE)
public @interface IsCustomersDelete {
}
