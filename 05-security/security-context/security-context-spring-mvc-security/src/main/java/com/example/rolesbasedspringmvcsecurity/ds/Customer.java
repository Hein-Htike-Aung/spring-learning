package com.example.rolesbasedspringmvcsecurity.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 2, max = 5, message = "Code must have length of 2  - 5 characters.")
    @Pattern(regexp = "[A-Za-z]*", message = "Code contains illegal characters.")
    private String code;

    @NotBlank(message = "First name cannot be empty!")
    @Pattern(regexp = "[A-Za-z-']*", message = "First name  contains illegal characters.")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty!")
    @Pattern(regexp = "[A-Za-z-']*", message = "Last name  contains illegal characters.")
    private String lastName;

    @NotBlank(message = "Address cannot be empty!")
    @Pattern(regexp = "[\\w .\\-/,]*", message = "Address contains illegal characters.")
    private String address;

    public Customer() {

    }
}
