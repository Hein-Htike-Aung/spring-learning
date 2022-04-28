package com.example.springsecuritydemo01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        var userDetailsService = new InMemoryUserDetailsManager();
//
//        var user = User.withUsername("xiaoting")
//                .password("12345")
//                .authorities("read")
//                .build();
//
//        userDetailsService.createUser(user);
//
//        return userDetailsService;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        var userDetailsService = new InMemoryUserDetailsManager();
//
//        var user = User.withUsername("xiaoting")
//                .password("12345")
//                .authorities("read")
//                .build();
//
//        userDetailsService.createUser(user);
//
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("xiaoting")
                .password("12345")
                .authorities("read")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic();

        // All the users need to be authenticated
        http.authorizeRequests().anyRequest().authenticated();

        // All the users will allow
//        http.authorizeRequests().anyRequest().permitAll();
    }

}
