package com.example.jwtsignkeyresourceserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("${jwt.key}")
    private String jwtKey;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

        resources.tokenStore(tokenStore());
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        var convector = new JwtAccessTokenConverter();
        convector.setSigningKey(jwtKey);
        return convector;
    }
}

// Token came from auth Server (Auth Server and Resource Server connected through Jwt token)
// curl -H "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MzgyMDE0ODQsInVzZXJfbmFtZSI6InhpYW90aW5nIiwiYXV0aG9yaXRpZXMiOlsicmVhZCJdLCJqdGkiOiJjY2M5MjI1MS0zYTIxLTRhN2QtYmZlOS0zYjdmMzJlZjJjZWQiLCJjbGllbnRfaWQiOiJjbGllbnQiLCJzY29wZSI6WyJyZWFkIl19.kipc8uvj9T1Qqz_I7_K0ZfdXuIhzVSS6ZxZegjcnhv4" http://localhost:9090/hello
