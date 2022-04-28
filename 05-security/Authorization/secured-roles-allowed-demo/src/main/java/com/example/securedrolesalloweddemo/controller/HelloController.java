package com.example.securedrolesalloweddemo.controller;

import com.example.securedrolesalloweddemo.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.StyleContext;

@RestController
public class HelloController {

    @Autowired
    private NameService nameService;

    // curl -u xiaoting:12345 localhost:8080/hello
    // curl -u karina:12345 localhost:8080/hello
    @GetMapping("/hello")
    public String hello() {
        return nameService.getName();
    }
}
