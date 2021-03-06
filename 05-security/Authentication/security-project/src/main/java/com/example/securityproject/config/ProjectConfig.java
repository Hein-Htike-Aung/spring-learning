package com.example.securityproject.config;

import com.example.securityproject.security.CustomAuthenticationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProviderService customAuthenticationProviderService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // set CustomAuthenticationProvider by using AuthenticationManagerBuilder
        auth.authenticationProvider(customAuthenticationProviderService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // using form Login
        http.formLogin()
                .defaultSuccessUrl("/main", true);

        http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SCryptPasswordEncoder sCryptPasswordEncoder() {
        return new SCryptPasswordEncoder();
    }
}
