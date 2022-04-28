package com.example.resourceserverdemo01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


// token came from auth Server (client going to access to Resource Server)
// curl -v -X POST -u resourceserver:resouceserversecret "http://localhost:8080/oauth/check_token?token=a3bda121-954b-441a-b6fe-5516ddf5467c"

    // can access to Resource Server
// curl -H "Authorization: bearer a3bda121-954b-441a-b6fe-5516ddf5467c" http://localhost:9090/hello

    @GetMapping("/hello")
    public String hello() {

        return "Hello";
    }
}
