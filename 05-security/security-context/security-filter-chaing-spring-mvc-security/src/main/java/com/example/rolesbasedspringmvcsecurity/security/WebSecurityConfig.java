package com.example.rolesbasedspringmvcsecurity.security;

import com.example.rolesbasedspringmvcsecurity.security.filter.CustomizedRequestParamAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import static com.example.rolesbasedspringmvcsecurity.security.SecurityRoles.*;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RoleHierarchy roleHierarchy;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("john")
                .password(encoder.encode("john"))
                .roles(SUPER_ADMIN)
                .and()

                .withUser("emma")
                .password(encoder.encode("emma"))
                .roles(EMPLOYEES_ADMIN)
                .and()

                .withUser("william")
                .password(encoder.encode("william"))
                .roles(DEPARTMENTS_ADMIN)
                .and()

                .withUser("lucas")
                .password(encoder.encode("lucas"))
                .roles(CUSTOMERS_ADMIN)
                .and()

                .withUser("tom")
                .password(encoder.encode("tom"))
                .roles();

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http

                .addFilterBefore(new CustomizedRequestParamAuthenticationFilter(), LogoutFilter.class)

                .authorizeRequests()
                .expressionHandler(defaultWebSecurityExpressionHandler())

                .mvcMatchers("/", "/home").permitAll()

                .mvcMatchers("/employees").hasRole(EMPLOYEES_PAG_VIEW)
                .mvcMatchers("/departments").hasRole(DEPARTMENTS_PAG_VIEW)
                .mvcMatchers("/customers").hasRole(CUSTOMERS_PAG_VIEW)

                .anyRequest().authenticated()
                .and()

                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                .permitAll()
                .and()

                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();
    }

    // set RoleHierarchy into SecurityExpressionHandler
    private DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler() {

        DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHierarchy);

        return expressionHandler;
    }
}
