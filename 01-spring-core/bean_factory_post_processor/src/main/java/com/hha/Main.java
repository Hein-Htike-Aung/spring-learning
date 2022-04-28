package com.hha;

import com.hha.beans.PropertyReadingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        PropertyReadingBean propertyReadingBean = context.getBean(PropertyReadingBean.class);
        propertyReadingBean.printProperties();
    }
}
