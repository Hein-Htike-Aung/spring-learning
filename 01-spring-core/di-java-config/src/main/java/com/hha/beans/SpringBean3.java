package com.hha.beans;

import org.springframework.stereotype.Component;


public class SpringBean3 {

    public SpringBean3() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }
}
