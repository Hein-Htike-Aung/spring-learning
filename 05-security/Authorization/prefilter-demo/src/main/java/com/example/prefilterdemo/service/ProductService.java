package com.example.prefilterdemo.service;

import com.example.prefilterdemo.model.Product;
import org.apache.catalina.LifecycleState;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    // authentication.name -> loginUser's name
    @PreFilter("filterObject.owner == authentication.name")
    public List<Product> sellProducts(List<Product> products) {
        return products;
    }
}
