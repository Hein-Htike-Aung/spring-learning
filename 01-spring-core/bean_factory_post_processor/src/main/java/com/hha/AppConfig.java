package com.hha;

import org.springframework.context.annotation.*;

@ComponentScan
@PropertySources({
        @PropertySource("classpath:/app-default.properties")
})
public class AppConfig {

    @Bean
    public static CustomBeanFactoryPostProcessor customBeanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }
}
