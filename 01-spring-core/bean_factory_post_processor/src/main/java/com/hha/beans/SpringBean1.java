package com.hha.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBean1 {


    @Bean(initMethod = "initMethod")
    private void initMethod(){
        System.out.println("Init");
    }

    @Bean(destroyMethod = "destroyMethod")
    private void destroyMethod() {
        System.out.println("Destroy");
    }
}
