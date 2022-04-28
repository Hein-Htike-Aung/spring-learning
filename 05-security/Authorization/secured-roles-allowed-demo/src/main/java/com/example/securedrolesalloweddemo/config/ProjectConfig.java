package com.example.securedrolesalloweddemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(
        jsr250Enabled = true,
        securedEnabled = true
)
public class ProjectConfig extends GlobalMethodSecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService() {

        var userDetailsService = new InMemoryUserDetailsManager();

        var user01 = User.withUsername("xiaoting").password("12345").roles("admin").build();
        var user02 = User.withUsername("karina").password("12345").roles("manager").build();

        userDetailsService.createUser(user01);
        userDetailsService.createUser(user02);

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
