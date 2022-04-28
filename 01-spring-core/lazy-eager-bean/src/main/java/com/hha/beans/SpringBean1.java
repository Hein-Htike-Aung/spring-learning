package com.hha.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SpringBean1 {

    public SpringBean1() {
        System.out.println(getClass().getSimpleName() + "::Singleton Bean With Lazy");
    }
}
