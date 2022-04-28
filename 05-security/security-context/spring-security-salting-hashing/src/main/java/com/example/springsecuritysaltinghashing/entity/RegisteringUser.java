package com.example.springsecuritysaltinghashing.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RegisteringUser {

    @NotBlank(message = "Username can't be empty.")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Username contains illegal characters!")
    private String username;

    @NotBlank(message = "Password can't be empty.")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Password is weak.(Please enter the text with numbers)")
    private String password;

    @NotBlank(message = "Repeated Password can't be empty.")
    private String repeatedPassword;

}
