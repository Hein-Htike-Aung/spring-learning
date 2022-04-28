package com.hha;

import com.hha.beans.SpringBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.AnnotatedArrayType;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        SpringBean springBean = context.getBean(SpringBean.class);
        springBean.printProperties();
    }
}
