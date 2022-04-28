package com.hha.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpringBean4 {

    // Singleton
    @Autowired
    private SpringBean2 springBean2;

    public SpringBean4() {
        System.out.println(getClass().getSimpleName() + "::Prototype Bean that has dependency on Singleton Bean");
    }
}
