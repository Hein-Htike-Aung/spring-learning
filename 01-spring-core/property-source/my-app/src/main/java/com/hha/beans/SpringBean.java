package com.hha.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {

    @Value("${app.env}")
    private String appEnv;

    @Value("${name}")
    private String name;

    public void printProperties() {

        System.out.println(appEnv);
        System.out.println(name);
    }
}
