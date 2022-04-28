package com.example.hateoasspringcrud.controller;

import com.example.hateoasspringcrud.dao.AddressDao;
import com.example.hateoasspringcrud.dao.CustomerDao;
import com.example.hateoasspringcrud.ds.Address;
import com.example.hateoasspringcrud.ds.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Entity;
import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CustomerController {

    public static final Class<CustomerController> CUSTOMER_CONTROLLER_CLASS = CustomerController.class;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @GetMapping("/customers")
    public CollectionModel<EntityModel<Customer>> listCustomer() {

        // Customer EntityModel List
        List<EntityModel<Customer>> customerEntityModel =

                // Find All Customers
                StreamSupport.stream(customerDao.findAll().spliterator(), false)

                        // Add into EntityModel
                        .map(customer ->
                                EntityModel.of(customer,

                                        // One Customer
                                        linkTo(methodOn(CUSTOMER_CONTROLLER_CLASS).getCustomer(customer.getId())).withSelfRel(),

                                        // Customer Address List
                                        linkTo(methodOn(CUSTOMER_CONTROLLER_CLASS).listAddresses(customer.getId())).withRel("addresses")
                                )).collect(Collectors.toList());

        Link customersLink = linkTo(methodOn(CUSTOMER_CONTROLLER_CLASS)).withSelfRel();

        return CollectionModel.of(customerEntityModel, customersLink);

    }


    @GetMapping("/customers/{id}")
    public EntityModel<Customer> getCustomer(@PathVariable int id) {

        // Find Customer By id
        Optional<Customer> customer = customerDao.findById(id);

        if (!customer.isPresent()) {
            throw new EntityNotFoundException("Id -> " + id);
        }

        // Add into EntityModel
        EntityModel<Customer> resource = EntityModel.of(customer.get());

        // One Customer
        resource.add(linkTo(methodOn(CUSTOMER_CONTROLLER_CLASS).getCustomer(id)).withSelfRel());

        // Customer Address List
        resource.add(linkTo(methodOn(CUSTOMER_CONTROLLER_CLASS).listAddresses(id)).withRel("addresses"));

        return resource;

    }

    @GetMapping("/customers/{customerId}/addresses")
    public CollectionModel<EntityModel<Address>> listAddresses(@PathVariable int customerId) {

        // Find Customer
        Customer customer = getCustomerById(customerId);

        List<EntityModel<Address>> addresses = customer.getAddresses().stream()

                // Add into EntityModel
                .map(address ->
                        EntityModel.of(address,

                                // Address
                                linkTo(methodOn(CUSTOMER_CONTROLLER_CLASS).getAddress(customerId, address.getId())).withSelfRel(),

                                // Address's Customer
                                linkTo(methodOn(CUSTOMER_CONTROLLER_CLASS).getCustomer(address.getCustomer().getId())).withRel("customer")
                        )).collect(Collectors.toList());

        return CollectionModel.of(addresses);
    }

    @GetMapping("/customers/{customerId}/address/{addressId}")
    public EntityModel<Address> getAddress(@PathVariable int customerId, @PathVariable int addressId) {

        // Find Address by using customerId and addressId
        Customer customer = getCustomerById(customerId);
        Address address = customer.getAddresses().stream()
                .filter(add -> add.getId() == addressId)
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return EntityModel.of(address,

                // Address
                linkTo(methodOn(CUSTOMER_CONTROLLER_CLASS).getAddress(customerId, addressId)).withSelfRel(),

                // Address's Customer
                linkTo(methodOn(CUSTOMER_CONTROLLER_CLASS).getCustomer(customerId)).withRel("customer"));

    }


    private Customer getCustomerById(int id) {

        return customerDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // curl -X POST -H "Content-Type:application/json" -d "{\"name\":\"MinJeong\"}" http://localhost:8080/customers
    @PostMapping("/customers")
    public EntityModel<Customer> createCustomer(@RequestBody Customer customer) {

        Customer createdCustomer = customerDao.save(customer);

        return EntityModel.of(createdCustomer,
                linkTo(methodOn(CUSTOMER_CONTROLLER_CLASS).getCustomer(createdCustomer.getId())).withSelfRel()
        );
    }

    // curl -X POST -H "Content-Type:application/json" -d "{\"addressName\":\"USR street\", \"customer\":\"\"}" http://localhost:8080/customers/4/addresses
    @PostMapping("/customers/{customerId}/addresses")
    public EntityModel<Address> createAddress(@PathVariable int customerId, @RequestBody Address address) {

        // Managed State Customer
        Customer customer = getCustomerById(customerId);

        // Transient State Address
        address.setCustomer(customer);

        // Save Managed State Address
        address = addressDao.save(address);

        // set Managed State address into Managed State customer
        customer.getAddresses().add(address);

        // // Save Managed State customer
        customerDao.save(customer);

        return EntityModel.of(address,
                linkTo(methodOn(CUSTOMER_CONTROLLER_CLASS).getAddress(customerId, address.getId())).withSelfRel()
        );
    }

}
