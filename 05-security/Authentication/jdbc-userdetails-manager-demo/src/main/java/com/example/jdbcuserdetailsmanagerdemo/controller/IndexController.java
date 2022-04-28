package com.example.jdbcuserdetailsmanagerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    // curl -u xiaoting:12345 localhost:8080/hello
    @GetMapping("/hello")
    public String hello() {

        return "Hello";
    }
}
