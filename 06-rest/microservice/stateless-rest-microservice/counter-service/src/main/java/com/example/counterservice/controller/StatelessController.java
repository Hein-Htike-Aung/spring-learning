package com.example.counterservice.controller;

import com.example.counterservice.ds.CounterServiceRequest;
import com.example.counterservice.ds.CounterServiceResponse;
import com.example.counterservice.service.MutableCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter/stateless")
public class StatelessController {

    /*
    *
    * Rest is stateless
    * Client request must add up the required information to handle the request
    * The state should not be stored on server side
    * */

    // curl -X POST -H "Content-Type:application/json" -d "{\"number\":\"4\"}" http://localhost:8080/counter/stateless/countUp |jq
    @PostMapping("/countUp")
    public CounterServiceResponse countUp(@RequestBody CounterServiceRequest counterServiceRequest) {

        return new CounterServiceResponse(counterServiceRequest.getNumber() + 1);
    }
}
