package com.hha.advanced;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigAdvanced.class);
        context.registerShutdownHook();

        Arrays.stream(context.getBeanDefinitionNames()).
                forEach(System.out::println);
    }
}
