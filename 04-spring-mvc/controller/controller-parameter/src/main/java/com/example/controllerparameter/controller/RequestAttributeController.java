package com.example.controllerparameter.controller;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class RequestAttributeController {

    // curl http://localhost:8080/requestAttribute01
    @GetMapping("/requestAttribute01")
    @ResponseBody
    public String requestAttribute01(
            @RequestAttribute("processing-time") String processingTime
    ) {
        return String.format("processing time = [%s]", processingTime);
    }

    // curl http://localhost:8080/requestAttribute01
    @GetMapping("/requestAttribute02")
    @ResponseBody
    public String requestAttribute02(
            @RequestAttribute("processing-time") LocalDateTime processingTime
    ) {
        return String.format("processing time = [%s]", processingTime);
    }

    // curl http://localhost:8080/requestAttribute03
    @GetMapping("/requestAttribute03")
    @ResponseBody
    public String requestAttribute03(
            @RequestAttribute(value = "non-existing-processing-time", required = false) LocalDateTime processingTime
    ) {
        return String.format("processing time = [%s]", processingTime);
    }

    // curl http://localhost:8080/requestAttribute04
    @GetMapping("/requestAttribute04")
    @ResponseBody
    public String requestAttribute04(
            @RequestAttribute(value = "non-existing-processing-time", required = false) Optional<LocalDateTime> processingTime
    ) {
        return String.format("processing time = [%s]", processingTime.orElse(LocalDateTime.now()));
    }


}
