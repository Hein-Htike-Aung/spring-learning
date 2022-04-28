package com.hha;

import com.hha.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public SpringBean1 springBean1(SpringBean2 springBean2, SpringBean3 springBean3) {
        return new SpringBean1(springBean2, springBean3);
    }

    @Bean
    public SpringBean3 springBean3() {
        return new SpringBean3();
    }

    @Bean
    public SpringBean2 springBean2() {
        return new SpringBean2();
    }

    @Bean
    @Scope("prototype")
    public SpringBean4 springBean4() {
        return new SpringBean4();
    }

    @Bean
    public SpringBean5 springBean5() {
        return new SpringBean5();
    }

}
