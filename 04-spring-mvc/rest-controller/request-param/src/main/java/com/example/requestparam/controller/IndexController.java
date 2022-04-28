package com.example.requestparam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class IndexController {

    // curl "localhost:8080/actionA?name=Xiao_ting"
    // curl localhost:8080/actionA
    @GetMapping("/actionA")
    public String actionA(@RequestParam("name") String name) {

        return String.format("Retrieved name = [%s]\n", name);
    }

    // curl "localhost:8080/actionB?name=Xiao_ting"
    // curl "localhost:8080/actionB?name=Xiao_ting&city=NYC"
    @GetMapping("/actionB")
    public String actionB(@RequestParam("name") String name, @RequestParam(value = "city", required = false) String city) {
        return String.format("Retrieved name = [%s], city = [%s]\n", name, city);
    }

    // curl "localhost:8080/actionC?name=Xiao_ting"
    // curl "localhost:8080/actionC?name=Xiao_ting&city=NYC"
    @GetMapping("/actionC")
    public String actionC(@RequestParam("name") String name, @RequestParam(value = "city", required = false, defaultValue = "Seoul") String city) {
        return String.format("Retrieved name = [%s], city = [%s]\n", name, city);
    }

    // curl "localhost:8080/actionD?name=Xiao_ting"
    // curl "localhost:8080/actionD?name=Xiao_ting&city=NYC"
    @GetMapping("/actionD")
    public String actionD(@RequestParam("name") String name, @RequestParam(value = "city") Optional<String> city) {
        return String.format("Retrieved name = [%s], city = [%s]\n", name, city.orElse(("Seoul")));
    }

    // curl "localhost:8080/actionE?name=Xiao_ting&city=Seoul&country=Korea"
    @GetMapping("/actionE")
    public String actionE(@RequestParam Map<String, String> parameters) {

        String parameterAsString = parameters.entrySet().stream()
                .map(entry -> String.format("[%s] -> [%s]", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));

        return String.format("Retrieved Parameters = [%s]\n" , parameterAsString);
    }

    // curl "localhost:8080/actionF?cities=NYC,Seoul
    @GetMapping("/actionF")
    public String actionF(@RequestParam("cities")List<String> cities) {

        return String.format("Retrieve cities = [%s]", String.join(", ", cities));
    }

}
