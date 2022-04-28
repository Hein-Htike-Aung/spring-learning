package com.example.rolesbasedspringmvcsecurity.security;

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

                .withUser("char")
                .password(encoder.encode("char"))
                .roles(ALL_VIEWS)
                .and()

                .withUser("joe")
                .password(encoder.encode("joe"))
                .roles(ALL_CREATES)
                .and()

                .withUser("shawn")
                .password(encoder.encode("shawn"))
                .roles(ALL_DELETES)
                .and()

                .withUser("tom")
                .password(encoder.encode("tom"))
                .roles();

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .expressionHandler(defaultWebSecurityExpressionHandler())

                .mvcMatchers("/", "/home").permitAll()
                .mvcMatchers("/employees").hasRole(EMPLOYEES_PAG_VIEW)
                .mvcMatchers("/employees/view/*").hasRole(EMPLOYEES_VIEW)
                .mvcMatchers("/employees/create").hasRole(EMPLOYEES_CREATE)
                .mvcMatchers("/employees/delete/*").hasRole(EMPLOYEES_DELETE)

                .mvcMatchers("/customers").hasRole(CUSTOMERS_PAG_VIEW)
                .mvcMatchers("/customers/view/**").hasRole(CUSTOMERS_VIEW)
                .mvcMatchers("/customers/create").hasRole(CUSTOMERS_CREATE)
                .mvcMatchers("/customers/**/delete/*").hasRole(CUSTOMERS_DELETE)

                .mvcMatchers("/depar?me???").hasRole(DEPARTMENTS_PAG_VIEW)
                .mvcMatchers("/departments/view/**").hasRole(DEPARTMENTS_VIEW)
                .mvcMatchers("/departments/**/create").hasRole(DEPARTMENTS_CREATE)
                .mvcMatchers("/departments/**/delete/**").hasRole(DEPARTMENTS_DELETE)

                .mvcMatchers("/**/view/**").hasRole(ALL_VIEWS)
                .mvcMatchers("/**/create/**").hasRole(ALL_CREATES)
                .mvcMatchers("/**/delete/**").hasRole(ALL_DELETES)

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
