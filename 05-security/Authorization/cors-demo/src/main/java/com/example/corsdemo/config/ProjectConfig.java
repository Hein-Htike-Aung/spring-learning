package com.example.corsdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Add cors to access to XMLHttpRequest at 'http://127.0.0.1:8080/test' from origin 'http://localhost:8080'
        http.cors(httpSecurityCorsConfigurer -> {
            CorsConfigurationSource source = request -> {
                CorsConfiguration corsConfiguration = new CorsConfiguration();

                corsConfiguration.setAllowedOrigins(List.of("*"));
                corsConfiguration.setAllowedMethods(List.of("*"));

                return corsConfiguration;
            };

            httpSecurityCorsConfigurer.configurationSource(source);
        });

        http.csrf().disable();

        http.authorizeRequests().anyRequest().permitAll();

    }
}
