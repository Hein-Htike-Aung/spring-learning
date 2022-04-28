package com.example.rolesbasedspringmvcsecurity.dao;

import com.example.rolesbasedspringmvcsecurity.ds.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersDao extends CrudRepository<Customer,Integer> {
}
