package com.example.springdatarest.dao;

import com.example.springdatarest.ds.Address;
import com.example.springdatarest.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {
}
