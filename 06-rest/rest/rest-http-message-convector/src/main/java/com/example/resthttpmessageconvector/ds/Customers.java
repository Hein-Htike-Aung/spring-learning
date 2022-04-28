package com.example.resthttpmessageconvector.ds;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@JacksonXmlRootElement(localName = "customers")
public class Customers implements Serializable {

    @JacksonXmlProperty(localName = "customer")
    private List<Customer> customers = new LinkedList<>();


    public Customers() {
    }

    public Customers(Iterable<Customer> customers) {
        this.customers = StreamSupport.stream(customers.spliterator(), false)
                .collect(Collectors.toList());
    }

}
