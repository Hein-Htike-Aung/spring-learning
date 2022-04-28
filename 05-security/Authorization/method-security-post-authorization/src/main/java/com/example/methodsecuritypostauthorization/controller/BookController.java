package com.example.methodsecuritypostauthorization.controller;

import com.example.methodsecuritypostauthorization.model.Employee;
import com.example.methodsecuritypostauthorization.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // curl -u xiaoting:12345 localhost:8080/book/details/xiaoting
    // curl -u karina:12345 localhost:8080/book/details/karina
    @GetMapping("/book/details/{name}")
    public Employee getDetails(@PathVariable String name) {
        return bookService.getDetails(name);
    }
}
