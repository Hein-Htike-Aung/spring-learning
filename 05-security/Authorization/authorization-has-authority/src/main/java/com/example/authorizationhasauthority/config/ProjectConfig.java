package com.example.authorizationhasauthority.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        var manager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("xiaoting")
                .password("12345")
//                .authorities("READ")
//                .authorities("ROLE_ADMIN")
                .roles("ADMIN")
                .build();

        var user2 = User.withUsername("karina")
                .password("12345")
//                .authorities("WRITE", "READ", "DELETE")
//                .authorities("ROLE_MANAGER")
                .roles("MANAGER")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

        // check Authorization
//        http.authorizeRequests().anyRequest().hasAuthority("WRITE");
//        http.authorizeRequests().anyRequest().hasAnyAuthority("WRITE", "READ");
//        http.authorizeRequests().anyRequest().access("hasAuthority('READ') and !hasAuthority('DELETE')");

//        http.authorizeRequests().anyRequest().hasRole("ADMIN");
        http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "MANAGER");
    }
}
