package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    // curl localhost:8080/hello
    @GetMapping("/hello")
    public String getHello() {
        return "Get Hello";
    }

    // curl -X POST localhost:8080/hello
    @PostMapping("/hello")
    public String postHello() {
        return "Post Hello";
    }
}
