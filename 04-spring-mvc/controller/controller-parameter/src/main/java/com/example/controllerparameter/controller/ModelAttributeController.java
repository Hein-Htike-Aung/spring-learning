package com.example.controllerparameter.controller;


import com.example.controllerparameter.ds.Address;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.BindException;

@Controller
public class ModelAttributeController {

    // localhost:8080/modelAttribute
    @GetMapping("/modelAttribute")
    public String modelAttribute(
            @ModelAttribute Address address // th:object (use in address-form)
    ) {

        return "address-form";
    }

    @PostMapping("/modelAttribute")
    public String modelAttribute02(
            // (use in address-display)
            @ModelAttribute Address address,  // this address is the same above address object
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "address-form";
        } else {

            System.out.println(address);
            return "address-display";
        }
    }

}
