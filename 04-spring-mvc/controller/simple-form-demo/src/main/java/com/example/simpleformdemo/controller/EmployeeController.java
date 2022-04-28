package com.example.simpleformdemo.controller;

import com.example.simpleformdemo.ds.Employee;
import com.example.simpleformdemo.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("employee", new Employee());
        return "index";

    }

    @PostMapping("/save-employee")
    public String saveEmployee(@Valid Employee employee, BindingResult result) {

        if (result.hasErrors()) {
            return "/index";
        }

        // employee is command object
        employeeRepository.save(employee);
        return "redirect:/";
    }
}
