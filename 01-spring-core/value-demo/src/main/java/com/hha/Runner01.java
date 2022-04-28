package com.hha;

import com.hha.beans.SpringBean01;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner01 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        SpringBean01 springBean01 = context.getBean(SpringBean01.class);

//        @Value("#{500 * 0.9}")
        System.out.println(springBean01.getAccountBalance());

//        @Value("#{'Wall Street'.toUpperCase()}")
        System.out.println(springBean01.getStreetName());

//        @Value("#{springBean02.taxId}")
        System.out.println(springBean01.getTaxId());

//        @Value("#{springBean02.taxValue}")
        System.out.println(springBean01.getTaxValue());

//        @Value("#{${app.cases.map}}")
        System.out.println(springBean01.getCasesMap());

//        @Value("#{'${app.department.id}'.toUpperCase()}")
        System.out.println(springBean01.getDepartmentName());

    }
}
