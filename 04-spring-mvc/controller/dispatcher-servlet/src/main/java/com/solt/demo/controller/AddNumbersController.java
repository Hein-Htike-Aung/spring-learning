package com.solt.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddNumbersController {

    // @{/add-numbers(numberA=2,numberB=4)}
    @GetMapping("/add-numbers")
    public String addNumbers(@RequestParam("numberA") int numberA, @RequestParam("numberB") int numberB, Model model) {

        model.addAttribute("numberA", numberA);
        model.addAttribute("numberB", numberB);
        model.addAttribute("result", numberA + numberB);

        return "add-numbers";
    }
}
