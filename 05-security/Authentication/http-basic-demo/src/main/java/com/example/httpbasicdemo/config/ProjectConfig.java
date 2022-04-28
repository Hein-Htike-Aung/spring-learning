package com.example.httpbasicdemo.config;

import com.example.httpbasicdemo.handler.CustomAuthenticationFailureHandler;
import com.example.httpbasicdemo.handler.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.httpBasic(httpBasicConfigurer -> {
//            // For bad Credentials
//            httpBasicConfigurer.realmName("OTHER");
//            httpBasicConfigurer.authenticationEntryPoint(new CustomEntryPoint());
//        });
//
//        // all the users need to be authenticated
//        http.authorizeRequests().anyRequest().authenticated();
//    }

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                // successHandler and failureHandler are only associated with formLogin
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)
                .and()
                .httpBasic();

        http.authorizeRequests().anyRequest().authenticated();


    }
}
