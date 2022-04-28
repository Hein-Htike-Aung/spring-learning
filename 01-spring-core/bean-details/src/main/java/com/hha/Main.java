package com.hha;

import com.hha.beans.SpringBean01;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        SpringBean01 springBean01 = context.getBean(SpringBean01.class);
        springBean01.printDependencies();
    }
}
