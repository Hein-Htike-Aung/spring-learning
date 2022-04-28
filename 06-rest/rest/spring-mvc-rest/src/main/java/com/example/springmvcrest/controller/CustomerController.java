package com.example.springmvcrest.controller;

import com.example.springmvcrest.dao.CustomerDao;
import com.example.springmvcrest.ds.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    // curl -X GET http://localhost:8080/customers | jq
    @GetMapping("/customers")
    public Iterable<Customer> list() {

        return customerDao.findAll();
    }

    // curl -X GET http://localhost:8080/customers/1 | jq
    // curl -X GET http://localhost:8080/customers/8 | jq
    @GetMapping("/customers/{id}")
    public Customer get(@PathVariable int id) {
        return customerDao.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // curl -X POST -H "Content-type:application/json" -d "{\"code\":\"JD\", \"firstName\":\"John\", \"lastName\":\"Doe\", \"address\":\"Bridge\"}" http://localhost:8080/customers | jq
    // curl -X POST -H "Content-type:application/json" -d "{\"code\":\"JD\", \"firstName\":\"\", \"lastName\":\"Doe\", \"address\":\"Bridge\"}" http://localhost:8080/customers | jq
    @PostMapping("/customers")
    public ResponseEntity<Customer> create(@RequestBody @Valid Customer customer, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            Customer savedCustomer = customerDao.save(customer);
            return ResponseEntity
                    .created(URI.create("/customers/" + savedCustomer.getId()))  // location
                    .body(savedCustomer);

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format(" Request contains incorrected data = [%s]", getErrors(bindingResult)));
        }

    }

    // curl -v -X PUT -H "Content-type:application/json" -d "{\"code\":\"JF\", \"firstName\":\"xiao\", \"lastName\":\"ting\", \"address\":\"Child\"}" http://localhost:8080/customers/6 | jq
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> update(@RequestBody @Valid Customer customer, @PathVariable int id, BindingResult bindingResult) {

        // customer is new record whereas id is from old one

        if (!bindingResult.hasErrors()) {

            // Id is the same between New record & old record
            if (customerDao.existsById(id)) {
                customer.setId(id);
                Customer savedCustomer = customerDao.save(customer);

                return ResponseEntity.ok(savedCustomer);
            } else {
                return ResponseEntity.notFound().build();
            }

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format(" Request contains incorrected data = [%s]", getErrors(bindingResult)));
        }
    }

    // curl -v -X DELETE http://localhost:8080/customers/3
    @DeleteMapping("/customers/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (customerDao.existsById(id)) {
            customerDao.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String getErrors(BindingResult bindingResult) {

        return bindingResult.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
    }

}
