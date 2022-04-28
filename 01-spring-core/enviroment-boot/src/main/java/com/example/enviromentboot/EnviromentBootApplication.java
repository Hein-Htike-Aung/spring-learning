package com.example.enviromentboot;

import com.example.enviromentboot.beans.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnviromentBootApplication implements CommandLineRunner {

    @Autowired
    private SpringBean springBean;

    public static void main(String[] args) {
        SpringApplication.run(EnviromentBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(springBean.getAppDefaultProperty());

        System.out.println(springBean.getAppDevProperty());

//        -Dapp.vm.property=appVMPropertyValue
        System.out.println(springBean.getAppVMProperty());
    }
}
