package com.example.rolesbasedspringmvcsecurity.controller;


import com.example.rolesbasedspringmvcsecurity.dao.DepartmentsDao;
import com.example.rolesbasedspringmvcsecurity.ds.Department;

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
public class DepartmentsController {

    @Autowired
    private DepartmentsDao departmentsDao;

    @GetMapping("/departments")
    public ModelAndView index() {
        return new ModelAndView("departments", "departments", departmentsDao.findAll());
    }

    @GetMapping("/departments/create")
    public ModelAndView create() {
        return new ModelAndView("department-create", "department", new Department());
    }

    @PostMapping("/departments/create")
    public String create(@ModelAttribute @Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "department-create";
        } else {
            departmentsDao.save(department);
            return "redirect:/departments";
        }
    }

    @GetMapping("/departments/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("department-view", "department", departmentsDao.findById(id));
    }

    @GetMapping("/departments/delete/{id}")
    public String delete(@PathVariable Integer id) {
        departmentsDao.deleteById(id);
        return "redirect:/departments";
    }
}
