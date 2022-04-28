package com.example.rolesbasedspringmvcsecurity.controller;


import com.example.rolesbasedspringmvcsecurity.dao.CustomersDao;
import com.example.rolesbasedspringmvcsecurity.ds.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static com.example.rolesbasedspringmvcsecurity.security.SecurityRoles.*;


/*
* Using Method security with securedEnabled
* */

@Controller
public class CustomersController {

    @Autowired
    private CustomersDao customersDao;


    @Secured(ROLE_PREFIX + CUSTOMERS_READ)
    @GetMapping("/customers")
    public ModelAndView index() {
        return new ModelAndView("customers", "customers", customersDao.findAll());
    }

    @Secured(ROLE_PREFIX + CUSTOMERS_CREATE)
    @GetMapping("/customers/create") // th:href="@{/customers/create}" button
    public ModelAndView create() {
        return new ModelAndView("customer-create", "customer", new Customer());
    }

    @Secured(ROLE_PREFIX + CUSTOMERS_CREATE)
    @PostMapping("/customers/create") // th:action="@{/customers/create}" within form
    public String create(@ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer-create";
        } else {
            customersDao.save(customer);
            return "redirect:/customers";
        }
    }

    @Secured(ROLE_PREFIX + CUSTOMERS_DELETE)
    @GetMapping("/customers/delete/{id}")
    public String delete(@PathVariable Integer id) {
        customersDao.deleteById(id);
        return "redirect:/customers";
    }
}
