package com.example.resthttpmessageconvector.controller;

import com.example.resthttpmessageconvector.dao.CustomerDao;
import com.example.resthttpmessageconvector.ds.Customer;
import com.example.resthttpmessageconvector.ds.Customers;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Content;
import com.rometools.rome.feed.rss.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class CustomerController {


    @Autowired
    private CustomerDao customerDao;

    /*
    * JSON
    *   consumes -> Request (client to server -> with client's object)    // INSERT, UPDATE, DELETE
    *   produces -> Response (server to client)   //  SELECT
    * */

    // curl -H "Accept:application/json" http://localhost:8080/customers |jq
    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Customer> listCustomersJSON() {
        return customerDao.findAll();
    }

    // curl -X POST -H "Content-Type:application/json" -d "{\"customerName\":\"IU\"}" http://localhost:8080/customers |jq
    @PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer createCustomerJSON(@RequestBody Customer customer) {

        return customerDao.save(customer);
    }


    /*
    * XML
    * */

    // curl -H "Accept:application/xml" http://localhost:8080/customers
    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_XML_VALUE)
    public Customers listCustomersXML() {
        return new Customers(customerDao.findAll());
    }

    // curl -X POST -H "Content-Type:application/xml" -d "<customer><customerName>IU 1993</customerName></customer>" http://localhost:8080/customers
    @PostMapping(value = "/customers", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Customer createCustomerXML(@RequestBody Customer customer) {
        return customerDao.save(customer);
    }


    /*
    *
    * RSS
    * */

    // curl -H "Accept:application/rss+xml" http://localhost:8080/customers
    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_RSS_XML_VALUE)
    public Channel listCustomersRSS() throws MalformedURLException {

        Channel channel = new Channel();

        channel.setFeedType("rss_2.0");
        channel.setTitle("Customers RSS");
        channel.setDescription("Example RSS Feed in Spring Boot");
        channel.setLink(
                ServletUriComponentsBuilder.fromCurrentRequest().build()
                        .toUri().toURL().toExternalForm()
        );

        List<Item> customersRssItems = StreamSupport.stream(customerDao.findAll().spliterator(), false)

                // Transform customer object into Item object
                .map(this::customerAsRSS)

                // Customer Item List
                .collect(Collectors.toList());

        channel.setItems(customersRssItems);

        return channel;
    }

    private Item customerAsRSS(Customer customer) {
        Item item = new Item();

        Content content = new Content();
        content.setType(Content.TEXT);
        content.setValue(customer.toString());

        item.setContent(content);
        return item;
    }



}
