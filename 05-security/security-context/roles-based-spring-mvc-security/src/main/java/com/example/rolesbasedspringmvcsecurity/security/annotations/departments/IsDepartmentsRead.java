package com.example.rolesbasedspringmvcsecurity.security.annotations.departments;


import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.example.rolesbasedspringmvcsecurity.security.SecurityRoles.DEPARTMENTS_READ;
import static com.example.rolesbasedspringmvcsecurity.security.SecurityRoles.ROLE_PREFIX;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Secured(ROLE_PREFIX + DEPARTMENTS_READ)
public @interface IsDepartmentsRead {
}
