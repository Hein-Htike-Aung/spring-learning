package com.example.onetoonedemo.dao;

import com.example.onetoonedemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address,Integer> {
}
