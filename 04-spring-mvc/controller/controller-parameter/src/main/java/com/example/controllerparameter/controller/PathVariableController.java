package com.example.controllerparameter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class PathVariableController {

    // curl http://localhost:8080/example01/firstName/Xiao/lastName/ting
    @GetMapping("/example01/firstName/{firstName}/lastName/{lastName}")
    @ResponseBody
    public String example01(
            @PathVariable String firstName,
            @PathVariable String lastName
    ) {

        return String.format("FirstName = [%s], LastName = [%s]", firstName, lastName);
    }

    // curl http://localhost:8080/example02/firstName/Xiao/lastName/ting
    // curl http://localhost:8080/example02/firstName/Xiao
    @GetMapping({"/example02/firstName/{firstName}/lastName/{lastName}", "/example02/firstName/{firstName}"})
    @ResponseBody
    public String example02(
            @PathVariable String firstName,
            @PathVariable(required = false) String lastName
    ) {

        return String.format("FirstName = [%s], LastName = [%s]", firstName, lastName);
    }

    // curl http://localhost:8080/example03/firstName/Xiao/lastName/ting
    // curl http://localhost:8080/example03/firstName/Xiao
    @GetMapping({"/example03/firstName/{firstName}/lastName/{lastName}", "/example03/firstName/{firstName}"})
    @ResponseBody
    public String example03(
            @PathVariable String firstName,
            @PathVariable(required = false) Optional<String> lastName
    ) {

        return String.format("FirstName = [%s], LastName = [%s]", firstName, lastName.orElse("N/A"));
    }

}
