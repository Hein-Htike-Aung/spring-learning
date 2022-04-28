package com.example.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello(Model model) {

        model.addAttribute("tagline", "Spring MVC");

        return "pages/index";
    }

    @GetMapping("/greet")
    public String greet(Model model) {

        model.addAttribute("tagline", "Xiaoting");

        return "pages/index";
    }

    @RequestMapping(value = {"/sayspring", "/sayMVC"}, method = RequestMethod.GET)
    public String saySpring(ModelMap modelMap) {

        modelMap.addAttribute("tagline", "MVC Test");
        return "pages/index";
    }

}
