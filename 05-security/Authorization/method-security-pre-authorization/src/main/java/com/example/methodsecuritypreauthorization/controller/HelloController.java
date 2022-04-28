package com.example.methodsecuritypreauthorization.controller;

import com.example.methodsecuritypreauthorization.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private NameService nameService;

    // curl -u xiaoting:12345 http://localhost:8080/hello
    // curl -u karina:12345 http://localhost:8080/hello
    @GetMapping("/hello")
    public String hello() {

        return nameService.getName();
    }

    // curl -u xiaoting:12345 localhost:8080/secret/name/xiaoting
    // curl -u xiaoting:12345 localhost:8080/secret/name/karina
    @GetMapping("/secret/name/{name}")
    public List<String> names(@PathVariable String name) {
        return nameService.getSecretNames(name);
    }
}
