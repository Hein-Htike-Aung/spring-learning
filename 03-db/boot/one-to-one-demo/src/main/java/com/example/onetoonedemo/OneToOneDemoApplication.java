package com.example.onetoonedemo;

import com.example.onetoonedemo.entity.Address;
import com.example.onetoonedemo.entity.Customer;
import com.example.onetoonedemo.service.AddressService;
import com.example.onetoonedemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class OneToOneDemoApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    public static void main(String[] args) {
        SpringApplication.run(OneToOneDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        customerService.saveData();

        // Address is an owner
        Address address = addressService.findAddressById(2);
        System.out.println(String.format("%s lives in %s", address.getCustomer().getName(), address.getStreetName()));

        // customer is an owner
        Customer customer = customerService.findCustomerById(1);
        System.out.println(String.format("%s lives in %s", customer.getName(), customer.getAddress().getStreetName()));

        System.out.println("\nDelete customer - 1");
        customerService.deleteCustomer(customerService.findCustomerById(1));

        System.out.println("\nAll Customers");
        List<Customer> lists = customerService.findAllCustomer();
        lists.stream().map(cus -> cus.getId() + " " + cus.getName() + " " + cus.getAddress().getStreetName()).forEach(System.out::println);

    }
}
