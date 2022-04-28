package com.hha.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpringBean6 {

    public SpringBean6() {
        System.out.println(getClass().getSimpleName() +
                "::Prototype Bean that has been referenced from Singleton Bean (Spring Bean5)");
    }
}
