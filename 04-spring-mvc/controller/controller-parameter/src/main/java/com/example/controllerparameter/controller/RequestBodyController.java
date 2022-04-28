package com.example.controllerparameter.controller;

import com.example.controllerparameter.ds.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class RequestBodyController {


    // curl -X POST -d "{\"firstName\":\"Xiao\", \"lastName\":\"ting\"}" -H "Content-Type:application/json" http://localhost:8080/requestBody01
    @PostMapping("/requestBody01")
    @ResponseBody
    public String requestBody01(
            @RequestBody(required = false) String body
    ) {

        return String.format("Request body = [%s]", body);
    }

    // curl -X POST -d "{\"firstName\":\"Xiao\", \"lastName\":\"ting\"}" -H "Content-Type:application/json" http://localhost:8080/requestBody02
    // curl -X POST -H "Content-Type:application/json" http://localhost:8080/requestBody02
    @PostMapping("/requestBody02")
    @ResponseBody
    public String requestBody02(
            @RequestBody(required = false) Optional<Person> body
    ) {

        return String.format("Request body = [%s]", body.orElse(new Person()));
    }


    // curl -X POST -d "{\"firstName\":\"Xiao\", \"lastName\":\"ting\"}" -H "Content-Type:application/json" http://localhost:8080/requestBody03
    // curl -X POST -d "{\"firstName\":\"Xiao45435\", \"lastName\":\"ting234234\"}" -H "Content-Type:application/json" http://localhost:8080/requestBody03
    @PostMapping("/requestBody03")
    @ResponseBody
    public String requestBody03(
            @RequestBody @Valid Person body,
            BindingResult bindingResult
    ) {

        return String.format("Request body = [%s]\n, error count = [%s]", body, bindingResult.getErrorCount());
    }

}
