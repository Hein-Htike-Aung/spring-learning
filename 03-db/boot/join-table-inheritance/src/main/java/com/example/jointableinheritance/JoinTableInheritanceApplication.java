package com.example.jointableinheritance;

import com.example.jointableinheritance.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JoinTableInheritanceApplication implements CommandLineRunner {

    @Autowired
    private VetService vetService;

    public static void main(String[] args) {
        SpringApplication.run(JoinTableInheritanceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        vetService.saveVet();
//
//        vetService.findAllVets();
    }
}
