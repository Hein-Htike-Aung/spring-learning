package com.hha.demo;

import com.hha.demo.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        SpringBean1 springBean1 = context.getBean(SpringBean1.class);

        // BeanFactoryPostProcessor

        // SpringBean1 constructor

        // SpringBean2 constructor
        // postProcessBeforeInitialization
        // postConstruct
        // postProcessAfterInitialization
        // setBean2 (Bean2 is ready)

        // SpringBean3 constructor
        // postProcessBeforeInitialization
        // postConstruct
        // postProcessAfterInitialization
        // setBean3 (Bean3 is ready)

        // postProcessBeforeInitialization
        // postConstruct
        // postProcessAfterInitialization (Bean1 is ready)

        // Bean1 preDestroy
        // Bean2 preDestroy
        // Bean3 preDestroy

    }
}
