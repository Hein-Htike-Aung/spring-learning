package com.example.controllerparameter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class RequestHeaderController {

    /*
    * RequestHeader can also use required,defaultValue and Optional
    *
    * */

    // curl -H "Accept-Version:4343" http://localhost:8080/exampleA01
    // curl http://localhost:8080/exampleA01
    @GetMapping("/exampleA01")
    @ResponseBody
    public String exampleA01(
            @RequestHeader("Accept-Version") String acceptVersion
    ) {

        return String.format("Accept Version = [%s]", acceptVersion);
    }

    // curl -H "Accept-Version:4343" http://localhost:8080/exampleA02
    @GetMapping("/exampleA02")
    @ResponseBody
    public String exampleA02(@RequestHeader Map<String, String> headers) {
        return String.format("Accept-Version: [%s]", headers);
    }

}
