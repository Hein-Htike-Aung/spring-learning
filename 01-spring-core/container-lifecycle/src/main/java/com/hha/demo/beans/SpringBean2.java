package com.hha.demo.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBean2 {

    public SpringBean2() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }

    @PostConstruct
    public void postConstructMethod() {
        System.out.println(getClass().getSimpleName() + "::postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(getClass().getSimpleName() + "::preDestroy");
    }
}
