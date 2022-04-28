package com.example.prepostfilterspringdatajpa.repository;

import com.example.prepostfilterspringdatajpa.entiry.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Filtering with Product's name and loginUser's name
    @PostFilter("filterObject.owner == authentication.principal.username")
    List<Product> findProductByNameContains(String name);


    @Query("select p from Product p where p.name like %:name% and p.owner=?#{authentication.name}")
    public List<Product> findProductByNameContains2(String name);

}
