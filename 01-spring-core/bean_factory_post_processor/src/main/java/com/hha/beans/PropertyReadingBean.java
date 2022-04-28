package com.hha.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyReadingBean {

    @Value("${app.env}")
    private String appenv;

    @Value("${app.envid}")
    private String appenvid;

    public void printProperties() {
        System.out.println("app.env = " + appenv);
        System.out.println("app.envid = " + appenvid);
    }
}
