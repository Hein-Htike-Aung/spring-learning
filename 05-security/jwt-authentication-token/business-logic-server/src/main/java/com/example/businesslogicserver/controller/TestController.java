package com.example.businesslogicserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class.getName());

    // login with username and password
    // curl -H "username:xiaoting" -H "password:12345" localhost:9090/login

    // login with username and code
    // curl -v -H "username:xiaoting" -H "code:5046" localhost:9090/login

    // login with jwt token
    // curl -H "Authorization:eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6InhpYW90aW5nIn0.JkgiA-DROKQddULBb7imf9Yl7eU5tw2KzeVbrZ1cmKyJkjxJhcL6ZB418XDm9NmZRAImJQmqSzHMmutxJl5mfg" localhost:9090/test
    @GetMapping("/test")
    public String test(
            Authentication authentication
    ) {

        logger.info("Name", authentication.getName());
        logger.info("Authorities" , authentication.getAuthorities());
        logger.info("IsAuthenticated" , authentication.isAuthenticated());

        return "Test";
    }


}
