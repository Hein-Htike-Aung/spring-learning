package com.example.securityproject.controller;

import com.example.securityproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @Autowired
    private ProductService productService;

    // Authentication not to be injected
    @GetMapping("/main")
    public String main(Authentication authentication, Model model) {

        model.addAttribute("username", authentication.getName());
        model.addAttribute("products", productService.findAllProducts());

        return "main";
    }
}
