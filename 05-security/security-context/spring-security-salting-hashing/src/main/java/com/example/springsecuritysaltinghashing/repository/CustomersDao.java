package com.example.springsecuritysaltinghashing.repository;


import com.example.springsecuritysaltinghashing.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersDao extends CrudRepository<Customer,Integer> {
}
