package com.hha.beans;

import org.springframework.stereotype.Component;

public class SpringBean2 {

    public SpringBean2() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }
}
