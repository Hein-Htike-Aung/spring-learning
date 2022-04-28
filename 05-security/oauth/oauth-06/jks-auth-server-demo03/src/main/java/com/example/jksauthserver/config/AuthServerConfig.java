package com.example.jksauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.util.List;


@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${password}")
    private String password;

    @Value("${privateKey}")

    private String privateKey;
    @Value("${alias}")

    private String alias;
    @Autowired

    private AuthenticationManager authenticationManager;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                .withClient("client")
                .secret("secret")
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("read");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        // Add Customize TokenEnhancer
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        var tokenTokenEnhancer = List.of(new CustomTokenEnhancer(), jwtAccessTokenConverter());
        tokenEnhancerChain.setTokenEnhancers(tokenTokenEnhancer);

        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore())
                .tokenEnhancer(tokenEnhancerChain);
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        var converter = new JwtAccessTokenConverter();
        KeyStoreKeyFactory keyStoreKeyFactory =
                new KeyStoreKeyFactory(
                        new ClassPathResource(privateKey),
                        password.toCharArray()
                );
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair(alias));
        return converter;
    }
}

// create hhs.jks file in project file path
// keytool -genkeypair -alias hha -keyalg RSA -keypass hha123 -keystore hha.jks -storepass hha123

// generate public key by using openssl(hha.jks) to give resource-server
// keytool -list -rfc --keystore hha.jks | openssl x509 -inform pem -pubkey

// generate access_token
// curl -v -X POST -u client:secret "http://localhost:8080/oauth/token?grant_type=password&username=xiaoting&password=12345&scope=read"