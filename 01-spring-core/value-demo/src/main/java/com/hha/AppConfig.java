package com.hha;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@ComponentScan
@Configuration
@PropertySources({
        @PropertySource("application.properties")
})
public class AppConfig {
}
