package com.hha.beans;

import org.springframework.stereotype.Component;


public class SpringBean1 {

    private SpringBean2 springBean2;
    private SpringBean3 springBean3;

    public SpringBean1(SpringBean2 springBean2, SpringBean3 springBean3) {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }

    public void sayHello() {
        System.out.println("Hello!");
    }
}
