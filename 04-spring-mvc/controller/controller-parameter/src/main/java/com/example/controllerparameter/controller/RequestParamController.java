package com.example.controllerparameter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class RequestParamController {

    // curl "http://localhost:8080/example01?firstName=John&lastName=Doe"
    @GetMapping("/example01")
    @ResponseBody // change to Rest
    public String example01(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {

        return String.format("FirstName = [%s], lastName = [%s]", firstName, lastName);
    }

    // curl "http://localhost:8080/example02?firstName=John&lastName=Doe"
    // curl "http://localhost:8080/example02?firstName=John"
    @GetMapping("/example02")
    @ResponseBody // change to Rest
    public String example02(
            @RequestParam("firstName") String firstName,
            @RequestParam(value = "lastName", required = false) String lastName) {

        return String.format("FirstName = [%s], lastName = [%s]", firstName, lastName);
    }

    // curl "http://localhost:8080/example03?firstName=John&lastName=Doe"
    // curl "http://localhost:8080/example03?firstName=John"
    @GetMapping("/example03")
    @ResponseBody // change to Rest
    public String example03(
            @RequestParam("firstName") String firstName,
            @RequestParam(value = "lastName", required = false, defaultValue = "N/A") String lastName) {

        return String.format("FirstName = [%s], lastName = [%s]", firstName, lastName);
    }

    // curl "http://localhost:8080/example04?firstName=John&lastName=Doe"
    // curl "http://localhost:8080/example04?firstName=John"
    @GetMapping("/example04")
    @ResponseBody // change to Rest
    public String example04(
            @RequestParam("firstName") String firstName,
            @RequestParam(value = "lastName") Optional<String> lastName) {

        return String.format("FirstName = [%s], lastName = [%s]", firstName, lastName.orElse("N/A"));
    }


}
