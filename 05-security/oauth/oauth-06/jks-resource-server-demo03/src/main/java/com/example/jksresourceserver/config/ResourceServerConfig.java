package com.example.jksresourceserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Map;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    // public key has been generated from .jks using openssl
    // keytool -list -rfc --keystore hha.jks | openssl x509 -inform pem -pubkey
    @Value("${publicKey}")
    private String publicKey;

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
        var convector = new AdditionalClaimsAccessTokenConvector();
        convector.setVerifierKey(publicKey);
        return convector;
    }

}

// Token came from jks auth server
// curl -H "Authorization:Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ4aWFvdGluZyIsInNjb3BlIjpbInJlYWQiXSwiZ2VuZXJhdGVkSW5ab25lIjoiQXNpYS9SYW5nb29uIiwiZXhwIjoxNjM4MjM2MzU4LCJhdXRob3JpdGllcyI6WyJyZWFkIl0sImp0aSI6IjJkNTE0ZTA0LTY0NDQtNDhkMC05YWQyLTE3NTc2ZmI4NmE3ZiIsImNsaWVudF9pZCI6ImNsaWVudCJ9.ZQrPN5T7mmoBXpv8-LTjDORV2BTh7sB2IXO4nxDMIrv58IRrYWjuQLHaw5iyeZDbw6imuGBTl7ldYXZMSuqM7NNlEeZgFt8Tl_tDeFnuVncONYR-Rfk0IsCuNCdXn2g1Kou4U2bXOO-8QJlrxYmtBh-OIgYOLSqnVJIACgBKU2i8jAODmD3m-OYmZqDT63RIp-ccjuPN3yHYLPL6PUlJMWbdhVkrQJX3JlOVORwnbcC3JGVmB5_GV_C4_qBwXkDKFRHnleHQf7p_VnqWqsUWap4yCn3u6uSSd33yWuJLNVzPeS2YGFoJ4l2i4Ex-GaLgxVI81TDdmnG7JbgM2bU8Yw" http://localhost:9090/hello
