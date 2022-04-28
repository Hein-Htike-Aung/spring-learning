package com.example.hateoasspringcrud.dao;


import com.example.hateoasspringcrud.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
