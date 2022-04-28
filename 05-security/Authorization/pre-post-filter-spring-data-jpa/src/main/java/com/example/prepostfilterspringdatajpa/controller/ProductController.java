package com.example.prepostfilterspringdatajpa.controller;

import com.example.prepostfilterspringdatajpa.entiry.Product;
import com.example.prepostfilterspringdatajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // curl -u xiaoting:12345 http://localhost:8080/products/mil
    // curl -u karina:12345 localhost:8080/products/strawbe
    // curl -u karina:12345 localhost:8080/products/mi
    @GetMapping("/products/{name}")
    public List<Product> findProductsByName(@PathVariable String name) {

//        return productRepository.findProductByNameContains(name);
        return productRepository.findProductByNameContains2(name);
    }
}
