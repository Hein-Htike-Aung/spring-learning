package com.example.jdbcuserdetailsmanagerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {

        // UserDetailsService with JdbcUserDetailsManager

        String findUserByUserName = "select username, password, enabled from users where username = ?";
        String authoritiesByUser = "select username, authority from authorities where username = ?";

        var userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery(findUserByUserName);
        userDetailsManager.setAuthoritiesByUsernameQuery(authoritiesByUser);

        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance();
    }
}
