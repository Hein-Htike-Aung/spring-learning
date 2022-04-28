package com.example.onetoonedemo.service;

import com.example.onetoonedemo.dao.AddressDao;
import com.example.onetoonedemo.dao.CustomerDao;
import com.example.onetoonedemo.entity.Address;
import com.example.onetoonedemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @Transactional
    public void saveData() {

        Customer customer1 = new Customer();
        customer1.setName("Xiaoting");
        customer1.setAge(22);
        Customer customer2 = new Customer();
        customer2.setName("MinJeong");
        customer2.setAge(18);

        Address address = new Address();
        address.setStreetName("Naway");
        address.setCity("Yangon");
        Address address2 = new Address();
        address2.setStreetName("Kenbo");
        address2.setCity("Seoul");

        // Mapping (address is an owner) Uni direction
//        address.setCustomer(customer1);
//        address2.setCustomer(customer2);

        // Mapping (customer is an owner) Uni direction/ Bi
        customer1.setAddress(address);
        customer2.setAddress(address2);

        // (cascade = CascadeType.PERSIST) // Address will save automatically
        customerDao.save(customer1);
        customerDao.save(customer2);

//        addressDao.save(address);
//        addressDao.save(address2);

    }

    public Customer findCustomerById(int id) {
        return customerDao.findById(id).orElse(null);
    }

    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }

    public List<Customer> findAllCustomer() {
        return customerDao.findAll();
    }

}
