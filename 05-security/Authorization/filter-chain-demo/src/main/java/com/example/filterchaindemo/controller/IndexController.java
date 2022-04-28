package com.example.filterchaindemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    // curl -H "Request-Id:12345" localhost:8080/hello
    // curl -H "Authorization:5BAA61E4C9B93F3F0682250B6CF8331B7EE68FD8" localhost:8080/hello
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
