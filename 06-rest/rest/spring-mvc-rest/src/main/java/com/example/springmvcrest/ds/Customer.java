package com.example.springmvcrest.ds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Code cannot be empty.")
    @Size(min = 2, max = 5, message = "Code length must be between 2 to 5")
    @Pattern(regexp = "[A-Za-z]*", message = "Code contains illegal characters")
    private String code;

    @NotBlank(message = "firstName cannot be empty.")
    @Pattern(regexp = "[A-Za-z]*", message = "firstName contains illegal characters")
    private String firstName;

    @NotBlank(message = "lastName cannot be empty.")
    @Pattern(regexp = "[A-Za-z]*", message = "lastName contains illegal characters")
    private String lastName;

    @NotBlank(message = "address cannot be empty.")
    @Pattern(regexp = "[\\w .\\-/,]*", message = "address contains illegal characters")
    private String address;


    public Customer() {
    }
}
