package com.example.requestmappinggetmapping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    // curl -X GET localhost:8080/actionA
    @GetMapping("/actionA")
    public String actionA() {

        return "Handled with @GetMapping (\"/action\")\n";
    }

    // curl -X GET localhost:8080/actionB
    @RequestMapping(method = RequestMethod.GET, path = "/actionB")
    public String actionB() {

        return "Handled with @RequestMapping(method=RequestMethod.GET, path=\"/actionB\")\n";
    }

    // curl -X GET localhost:8080/actionC
    // curl -X POST localhost:8080/actionC
    // curl -X PATCH localhost:8080/actionC
    @RequestMapping(path = "/actionC")
    public String actionC() {

        return "Handled with @RequestMapping(path=\"/actionC\")\n";
    }

    // curl -X GET localhost:8080/actionD
    // curl -X POST localhost:8080/actionD
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, path = "/actionD")
    public String actionD() {

        return "Handled with @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, path=\"/actionD\")\n";
    }

}
