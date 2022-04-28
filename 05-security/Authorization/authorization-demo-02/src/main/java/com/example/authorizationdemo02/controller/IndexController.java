package com.example.authorizationdemo02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    // curl -u xiaoting:12345 localhost:8080/admin
    @GetMapping("/admin")
    public String admin() {

        return "ADMIN";
    }


    // curl -u karina:12345 localhost:8080/manager
    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }


    // curl -u xiaoting:12345 localhost:8080/employee
    // curl -u karina:12345 localhost:8080/employee
    @GetMapping("/employee")
    public String employee() {
        return "employee";
    }
}
