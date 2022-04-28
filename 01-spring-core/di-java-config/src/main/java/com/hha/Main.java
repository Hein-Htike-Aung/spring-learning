package com.hha;

import com.hha.beans.SpringBean1;
import com.hha.beans.SpringBean4;
import com.hha.beans.SpringBean5;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

//        SpringBean1 springBean1 = context.getBean(SpringBean1.class);
//        springBean1.sayHello();

        // Bean with Prototype Scope (Lazily instantiated Object)
        // (If they are host bean, they are eagerly instantiated Object)
        System.out.println(context.getBean(SpringBean4.class));
        System.out.println(context.getBean(SpringBean4.class));
        System.out.println(context.getBean(SpringBean4.class));
        System.out.println(context.getBean(SpringBean4.class));

        System.out.println("\n");

        // Bean with Singleton Scope (Eagerly instantiated Object)
        System.out.println(context.getBean(SpringBean5.class));
        System.out.println(context.getBean(SpringBean5.class));
        System.out.println(context.getBean(SpringBean5.class));
        System.out.println(context.getBean(SpringBean5.class));

    }
}
