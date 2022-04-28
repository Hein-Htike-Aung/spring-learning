package com.example.backend.controller;

import com.example.backend.dao.CustomerDao;
import com.example.backend.ds.Customer;
import com.example.backend.ds.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomersController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/customers")
    public Customers listCustomer() {

        return new Customers(customerDao.findAll().spliterator());
    }

    // curl -X POST -H "Content-Type:application/json" -d "{\"customerName\":\"NingNing\"}" localhost:8081/api/customers/create
    @PostMapping("/customers/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerDao.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity createCustomer(@PathVariable int id) {

        if (customerDao.existsById(id)) {
            customerDao.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
