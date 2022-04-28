package com.example.rolesbasedspringmvcsecurity.controller;


import com.example.rolesbasedspringmvcsecurity.dao.EmployeesDao;
import com.example.rolesbasedspringmvcsecurity.ds.Employee;
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
public class EmployeeController {

    @Autowired
    private EmployeesDao employeesDao;

    @GetMapping("/employees")  // Navigation
    public ModelAndView index() {
        return new ModelAndView("employees", "employees", employeesDao.findAll());
    }

    @GetMapping("/employees/create")  // templates > employees -> th:href="@{/employees/create}"
    public ModelAndView create() {
        return new ModelAndView("employee-create", "employee", new Employee());
    }

    @PostMapping("/employees/create") // fragments > form -> th:action="@{/employees/create}"
    public String create(@ModelAttribute @Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee-create";
        } else {
            employeesDao.save(employee);
            return "redirect:/employees";
        }
    }

    @GetMapping("/employees/view/{id}") // fragments > table -> th:href="@{'/employees/view/'+ ${employee.id}}"
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("employee-view", "employee", employeesDao.findById(id));
    }

    @GetMapping("/employees/delete/{id}") // fragments > table -> th:href="@{'/employees/delete/'+ ${employee.id}}"
    public String delete(@PathVariable Integer id) {
        employeesDao.deleteById(id);
        return "redirect:/employees";
    }

}
