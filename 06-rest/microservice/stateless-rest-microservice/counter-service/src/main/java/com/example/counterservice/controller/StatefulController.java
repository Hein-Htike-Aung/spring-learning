package com.example.counterservice.controller;

import com.example.counterservice.ds.CounterServiceResponse;
import com.example.counterservice.service.MutableCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter/stateful")
public class StatefulController {

    @Autowired
    private MutableCounter mutableCounter;

    // curl -b cookies.txt -c cookies.txt -X POST http://localhost:8080/counter/stateful/countUp |jq
    // cookies location -> C:\Users\Dell
    @PostMapping("/countUp")
    public CounterServiceResponse countUp() {
        mutableCounter.countUp();

        return new CounterServiceResponse(mutableCounter.getNumber());
    }

}
