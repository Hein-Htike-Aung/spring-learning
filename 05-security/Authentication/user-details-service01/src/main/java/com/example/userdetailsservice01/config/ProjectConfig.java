package com.example.userdetailsservice01.config;

import com.example.userdetailsservice01.model.User;
import com.example.userdetailsservice01.service.InMemoryUserDetailsService;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = new User("xiaoting", "12345", "read");
        UserDetails user2 = new User("karina", "12345", "read");

        List<UserDetails> users = List.of(user, user2);

        return new InMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder (){

        return NoOpPasswordEncoder.getInstance();
    }

}
