package com.example.prefilterdemo.controller;

import com.example.prefilterdemo.model.Product;
import com.example.prefilterdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // curl -u xiaoting:12345 localhost:8080/find
    // curl -u karina:12345 localhost:8080/find
    @GetMapping("/find")
    public List<Product> getProducts() {

        return productService.findProducts();

    }
}
