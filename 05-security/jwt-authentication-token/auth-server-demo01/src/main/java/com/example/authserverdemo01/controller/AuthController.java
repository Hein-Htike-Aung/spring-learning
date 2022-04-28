package com.example.authserverdemo01.controller;

import com.example.authserverdemo01.entity.Otp;
import com.example.authserverdemo01.entity.User;
import com.example.authserverdemo01.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(AuthController.class.getName());

    // curl -X POST -H "Content-Type:application/json" -d "{\"username\":\"xiaoting\", \"password\":\"12345\"}" localhost:8080/user/add
    @PostMapping("/user/add")
    public void addUser(@RequestBody User user) {

        // Add New User
        userService.add(user);
    }

    // curl -X POST -H "Content-Type:application/json" -d "{\"username\":\"xiaoting\", \"password\":\"12345\"}" localhost:8080/user/auth
    @PostMapping("/user/auth")
    public void auth(@RequestBody User user) {

        // Check authentication and Add/Update User's Otp
        userService.auth(user);
    }

    // curl -v -X POST -H "Content-Type:application/json" -d "{\"username\":\"xiaoting\", \"code\":\"4396\"}" localhost:8080/otp/check
    @PostMapping("/otp/check")
    public void checkOtp(@RequestBody Otp otp, HttpServletResponse response) {

        if (userService.checkOtp(otp)) {

            // check response
            response.setStatus(HttpServletResponse.SC_OK);

            logger.info("Otp successfully authenticated");
        } else {

            // check response
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }

    }
}
