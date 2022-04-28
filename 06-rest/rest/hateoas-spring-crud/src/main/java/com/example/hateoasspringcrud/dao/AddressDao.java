package com.example.hateoasspringcrud.dao;


import com.example.hateoasspringcrud.ds.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {
}