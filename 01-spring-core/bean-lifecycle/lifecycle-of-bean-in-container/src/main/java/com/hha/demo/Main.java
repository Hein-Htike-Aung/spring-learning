package com.hha.demo;

import com.hha.demo.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        SpringBean1 springBean1 = context.getBean(SpringBean1.class);

//        SpringBean1::constructor
//        SpringBean1::setBean3 (evoke DI)
//        SpringBean1::setBean2 (evoke DI)

//        SpringBean1::postConstruct
//        InitializingBean::afterPropertiesSetSpringBean1
//        @Bean(initMethod)SpringBean1

//        SpringBean1::preDestroy
//        DisposableBean::destroySpringBean1
//        @Bean(destroy)SpringBean1

    }
}
