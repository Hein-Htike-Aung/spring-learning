package com.example.springmvcscopedemo.controller;

import com.example.springmvcscopedemo.beans.ApplicationScopeBean;
import com.example.springmvcscopedemo.beans.RequestScopeBean;
import com.example.springmvcscopedemo.beans.SessionScopeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class IndexController {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private RequestScopeBean requestScopeBean;

    @Autowired
    private SessionScopeBean sessionScopeBean;

    @Autowired
    private ApplicationScopeBean applicationScopeBean;

    @RequestMapping(path = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {

        model.addAttribute("servletContext", webApplicationContext.getServletContext());
        model.addAttribute("requestScopeValue", requestScopeBean.getValue());
        model.addAttribute("sessionScopeValue", sessionScopeBean.getValue());
        model.addAttribute("applicationScopeValue", applicationScopeBean.getValue());

        return "index";
    }


    @PostMapping("/saveRequestScopeValue")
    public String saveRequestScopeValue(@RequestParam("requestScopeValue") int requestScopeValue) {

        requestScopeBean.setValue(requestScopeValue);

        // forward means state lives within the request scope
        // redirect means make new request
        return "forward:/";
    }

    @PostMapping("/saveSessionScopeValue")
    public String saveSessionScopeValue(@RequestParam("sessionScopeValue") int sessionScopeValue) {

        sessionScopeBean.setValue(sessionScopeValue);
        return "forward:/";
    }

    @PostMapping("/saveApplicationScopeValue")
    public String saveApplicationScopeValue(@RequestParam("applicationScopeValue") int applicationScopeValue) {

        applicationScopeBean.setValue(applicationScopeValue);
        return "forward:/";

    }


}
