package com.example.springsecuritydemo01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // curl -u user:79ed22be-8f87-4dac-8932-c08352383b1e localhost:8080/hello // default
    // curl -u xiaoting:12345 localhost:8080/hello // customize
    // curl localhost:8080/hello // permit all
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
