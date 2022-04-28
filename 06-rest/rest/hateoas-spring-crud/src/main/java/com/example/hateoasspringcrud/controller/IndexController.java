package com.example.hateoasspringcrud.controller;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @GetMapping("/")
    public RepresentationModel index() {

        RepresentationModel representationModel = new RepresentationModel();


        representationModel.add(Link.of("http://localhost:8080/", "index"));
        representationModel.add(Link.of("http://localhost:8080/customers", "customers"));

        return representationModel;
    }

}
