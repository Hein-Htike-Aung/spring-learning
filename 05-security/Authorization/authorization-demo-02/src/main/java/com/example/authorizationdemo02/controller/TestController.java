package com.example.authorizationdemo02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // curl -X POST localhost:8080/a
    @PostMapping("/a")
    public String postEndPointA() {

        return "Works";
    }

    // curl -X GET -u xiaoting:12345 localhost:8080/a
    @GetMapping("/a")
    public String getEndPointA() {
        return "Wroks";
    }

    @GetMapping("/a/b")
    public String getEndPointB() {
        return "Wroks";
    }

    // curl -X GET -u xiaoting:12345 localhost:8080/a/b/c
    @GetMapping("/a/b/c")
    public String getEndPointC() {
        return "Wroks";
    }
}
