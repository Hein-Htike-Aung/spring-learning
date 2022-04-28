package com.example.methodsecuritypostauthorization.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Employee {

    private String name;

    private List<String> books;

    private List<String> roles;
}
