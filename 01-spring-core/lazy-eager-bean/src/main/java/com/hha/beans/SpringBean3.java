package com.hha.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpringBean3 {

    public SpringBean3() {
        System.out.println(getClass().getSimpleName() + "::prototype Bean");
    }
}
