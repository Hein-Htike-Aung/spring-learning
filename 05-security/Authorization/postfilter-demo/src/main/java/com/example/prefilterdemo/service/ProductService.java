package com.example.prefilterdemo.service;

import com.example.prefilterdemo.model.Product;
import org.apache.catalina.LifecycleState;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    @PostFilter("filterObject.owner == authentication.getName()")
    public List<Product> findProducts() {

        List<Product> products = new ArrayList<>();

        products.add(new Product("milk", "xiaoting"));
        products.add(new Product("strawberry", "xiaoting"));
        products.add(new Product("yogurt", "karina"));

        return products;
    }
}
