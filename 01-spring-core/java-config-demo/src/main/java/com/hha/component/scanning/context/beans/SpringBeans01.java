package com.hha.component.scanning.context.beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBeans01 {

    private final SpringBeans02 springBeans02;

    private final SpringBeans03 springBeans03;

    // Injection with Constructor
    public SpringBeans01(SpringBeans02 springBeans02, SpringBeans03 springBeans03) {
        this.springBeans02 = springBeans02;
        this.springBeans03 = springBeans03;
    }

    public void printDependencies() {
        System.out.println("Config with Component Scan");
        System.out.println(springBeans02.getClass().getSimpleName());
        System.out.println(springBeans03.getClass().getSimpleName());
    }
}
