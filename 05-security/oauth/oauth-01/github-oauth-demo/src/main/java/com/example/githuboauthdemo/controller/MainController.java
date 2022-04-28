package com.example.githuboauthdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class.getName());


    @GetMapping("/")
    public String main(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        logger.info("oAuth2AuthenticationToken -> " + oAuth2AuthenticationToken);

        return "main.html";
    }
}
