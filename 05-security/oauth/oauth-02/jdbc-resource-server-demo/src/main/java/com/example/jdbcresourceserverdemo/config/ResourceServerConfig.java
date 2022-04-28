package com.example.jdbcresourceserverdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

        // Auth server and resource server connected through JdbcTokenStore
        resources.tokenStore(tokenStore());
    }

    @Bean
    public TokenStore tokenStore() {

        return new JdbcTokenStore(dataSource);
    }
}

// access_token came from auth server
// curl -H "Authorization:Bearer 9893a9fb-4730-4a75-b941-1461eee18113" http://localhost:9090/hello