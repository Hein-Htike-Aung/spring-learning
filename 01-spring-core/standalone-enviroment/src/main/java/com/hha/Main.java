package com.hha;

import com.hha.beans.SpringBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        System.out.println(context.getEnvironment().getProperty("app.file.property"));
//        -Dapp.vm.property=appVMPropertyVallue
        System.out.println(context.getEnvironment().getProperty("app.vm.property"));
        System.out.println(context.getEnvironment().getProperty("JAVA_HOME"));


        System.out.println();
        SpringBean springBean = context.getBean(SpringBean.class);
        System.out.println(springBean.getAppFileProperty());
        System.out.println(springBean.getAppVMProperty());
        System.out.println(springBean.getJavaHome());

    }
}
