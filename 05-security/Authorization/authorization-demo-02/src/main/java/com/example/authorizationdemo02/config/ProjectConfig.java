package com.example.authorizationdemo02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {

        var manager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("xiaoting").password("12345").roles("ADMIN").build();
        var user2 = User.withUsername("karina").password("12345").roles("MANAGER").build();

        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

      /*  http.authorizeRequests()
                // @GetMapping("/admin")
                .mvcMatchers("/admin").hasRole("ADMIN")

                // @GetMapping("/manager")
                .mvcMatchers("/manager").hasRole("MANAGER") // admin can access to manager
                .anyRequest().authenticated(); // Allow all roles but it needs username & password*/

/*

        http.authorizeRequests()

                // @GetMapping("/a")
                .mvcMatchers(HttpMethod.GET, "/a").authenticated()

                // @PostMapping("/a")
                .mvcMatchers(HttpMethod.POST, "/a").permitAll()
                .anyRequest().denyAll();
*/

        http.authorizeRequests()
                // @GetMapping("/a")
                // @GetMapping("/a/b")
                // @GetMapping("/a/b/c")
                .mvcMatchers(HttpMethod.GET, "/a/**").authenticated()

//                // @GetMapping("/a/b/c")
//                .mvcMatchers(HttpMethod.GET, "/a/**/c").authenticated()
                .anyRequest().denyAll();


        http.csrf().disable();
    }
}
