package com.example.onetoonedemo.service;

import com.example.onetoonedemo.dao.AddressDao;
import com.example.onetoonedemo.dao.CustomerDao;
import com.example.onetoonedemo.entity.Address;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {


    @Autowired
    private AddressDao addressDao;

    @Autowired
    private CustomerDao customerDao;

    public Address findAddressById(int id) {
        return addressDao.findById(id).orElse(null);
    }

    public List<Address> findAllAddress() {
        return addressDao.findAll();
    }
}
