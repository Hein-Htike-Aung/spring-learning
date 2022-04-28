package com.example.springsecuritysaltinghashing.controller;


import com.example.springsecuritysaltinghashing.entity.Customer;
import com.example.springsecuritysaltinghashing.repository.CustomersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CustomersController {

    @Autowired
    private CustomersDao customersDao;

    @GetMapping("/customers")
    public ModelAndView index() {
        return new ModelAndView("customers", "customers", customersDao.findAll());
    }


    @GetMapping("/customers/create") // th:href="@{/customers/create}" button
    public ModelAndView create() {
        return new ModelAndView("customer-create", "customer", new Customer());
    }

    @PostMapping("/customers/create") // th:action="@{/customers/create}" within form
    public String create(@ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer-create";
        } else {
            customersDao.save(customer);
            return "redirect:/customers";
        }
    }

    @GetMapping("/customers/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("customer-view", "customer", customersDao.findById(id));
    }

    @GetMapping("/customers/delete/{id}")
    public String delete(@PathVariable Integer id) {
        customersDao.deleteById(id);
        return "redirect:/customers";
    }
}
