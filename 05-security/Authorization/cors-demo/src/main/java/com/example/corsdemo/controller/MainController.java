package com.example.corsdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class.getName());

    @GetMapping("/")
    public String main() {

        return "main";
    }

    @PostMapping("/test")
    @ResponseBody
//    @CrossOrigin("http://localhost:8080")
    public String test() {

        logger.info("Test Method is called.");
        return "Hello";
    }
}
