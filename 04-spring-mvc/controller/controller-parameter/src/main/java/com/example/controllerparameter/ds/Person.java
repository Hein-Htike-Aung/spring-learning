package com.example.controllerparameter.ds;

import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Person {

    @NotBlank(message = "firstName cannot be null")
    @Pattern(regexp = "[A-Za-z-']*", message = "First Name contains illegal characters")
    private String firstName;

    @NotBlank(message = "lastName cannot be null")
    @Pattern(regexp = "[A-Za-z-']*", message = "Last Name contains illegal characters")
    private String lastName;
}
