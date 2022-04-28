package com.example.ownauthserverdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

// For Client

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

  /*  @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated");
    }*/

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        // Create Client


//        clients.inMemory()
//                .withClient("client")
//                .secret("secret")
//                .authorizedGrantTypes("password", "refresh_token")
//                .scopes("read");

//        clients.inMemory()
//                .withClient("client")
//                .secret("secret")
//                //.authorizedGrantTypes("password", "refresh_token")
//                .authorizedGrantTypes("authorization_code", "refresh_token") // form login
//                .scopes("read")
//                .redirectUris("http://localhost:9090/home"); // form login

        clients.inMemory()
                .withClient("client")
                .secret("secret")
                //.authorizedGrantTypes("password", "refresh_token")
                .authorizedGrantTypes("client_credentials")
                .scopes("info");

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }
}

// curl -v -X POST -u client:secret "localhost:8080/oauth/token?grant_type=password&username=xiaoting&password=12345&scope=read"
// curl -X POST -u client:secret "localhost:8080/oauth/token?grant_type=password&username=xiaoting&password=12345&scope=read"


// In Browser (Auth Server want to check the Client is approvable), the auth server will give code
// http:localhost:8080/oauth/authorize?response_type=code&client_id=client&scope=read

// id1t71 // scope must be User's scope
// curl -v -X POST -u client:secret "localhost:8080/oauth/token?grant_type=authorization_code&scope=read&code=id1t71"

// curl -v -X POST -u client:secret "localhost:8080/oauth/token?grant_type=client_credentials&scope=info
