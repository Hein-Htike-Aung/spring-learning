package com.hha;

import com.hha.beans.SpringBean3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        // Prototype Bean
        context.getBean(SpringBean3.class);

        // Singleton Bean -> Eager
        // Singleton Bean (Lazy) -> Lazy

        // Prototype Bean -> Lazy
        // Prototype Bean in Singleton -> Eager
        // Prototype Bean that has dependency on Singleton -> Lazy
    }
}
