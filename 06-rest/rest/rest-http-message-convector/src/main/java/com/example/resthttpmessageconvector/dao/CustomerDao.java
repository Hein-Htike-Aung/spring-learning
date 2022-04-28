package com.example.resthttpmessageconvector.dao;

import com.example.resthttpmessageconvector.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
