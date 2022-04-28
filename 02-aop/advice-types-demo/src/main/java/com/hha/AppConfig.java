package com.hha;

import com.hha.aspects.EmployeeRepositoryAspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AppConfig {

//    @Bean
//    public EmployeeRepositoryAspect employeeRepositoryAspect () {
//        return new EmployeeRepositoryAspect();
//    }

}
