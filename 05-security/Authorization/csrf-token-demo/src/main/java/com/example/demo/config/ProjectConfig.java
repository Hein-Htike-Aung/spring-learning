package com.example.demo.config;

import com.example.demo.filter.CsrfTokenLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic();


        // Log CSRFToken
        http.addFilterAfter(new CsrfTokenLogger(), CsrfFilter.class)
                .authorizeRequests().anyRequest().permitAll();


        // Allow POST method not to forbid because all the POST methods need CSRFToken
//        http.csrf().disable();
    }
}
