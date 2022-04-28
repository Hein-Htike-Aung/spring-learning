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

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import static com.example.rolesbasedspringmvcsecurity.security.SecurityRoles.*;


/*
 *
 * Using Method security with jsr250Enabled (EJB annotations)
 * */
@Controller
public class DepartmentsController {

    @Autowired
    private DepartmentsDao departmentsDao;

    @RolesAllowed(ROLE_PREFIX + DEPARTMENTS_READ)
    @GetMapping("/departments")
    public ModelAndView index() {
        return new ModelAndView("departments", "departments", departmentsDao.findAll());
    }

    @RolesAllowed(ROLE_PREFIX + DEPARTMENTS_CREATE)
    @GetMapping("/departments/create")
    public ModelAndView create() {
        return new ModelAndView("department-create", "department", new Department());
    }

    @RolesAllowed(ROLE_PREFIX + DEPARTMENTS_CREATE)
    @PostMapping("/departments/create")
    public String create(@ModelAttribute @Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "department-create";
        } else {
            departmentsDao.save(department);
            return "redirect:/departments";
        }
    }

    @RolesAllowed(ROLE_PREFIX + DEPARTMENTS_DELETE)
    @GetMapping("/departments/delete/{id}")
    public String delete(@PathVariable Integer id) {
        departmentsDao.deleteById(id);
        return "redirect:/departments";
    }
}
