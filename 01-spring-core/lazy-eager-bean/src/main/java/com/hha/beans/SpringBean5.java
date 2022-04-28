package com.hha.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Singleton
@Component
public class SpringBean5 {

    // Prototype
    @Autowired
    private SpringBean6 springBean6;

    public SpringBean5() {
        System.out.println(getClass().getSimpleName() + "::Singleton Bean that has dependency on Prototype");
    }
}
