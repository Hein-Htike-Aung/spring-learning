package com.example.jksresourceserver.config;

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
        var convector = new JwtAccessTokenConverter();
        convector.setVerifierKey(publicKey);
        return convector;
    }
}

// Token came from jks auth server
// curl -H "Authorization:Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MzgyMzI1MDgsInVzZXJfbmFtZSI6InhpYW90aW5nIiwiYXV0aG9yaXRpZXMiOlsicmVhZCJdLCJqdGkiOiI1MGUxNzFkMy04ZTk3LTQ0MzMtOWIzMS1kMzkxYjVjNmY2MjciLCJjbGllbnRfaWQiOiJjbGllbnQiLCJzY29wZSI6WyJyZWFkIl19.gGocCUvH_-wM8i4LbL1jxVtcn_HXdkdph2xq9p21LaaBnMdbKlwI77L6cs7p-WBMh6IZvqD1-34TX1puu88eNL5MayMNREMmkezETx_wNsFm4O3GfLm-ZW9obn4bSn-ptAKlWP5BRx8EkV5g0MyMaathZexWL8FCPYgNkUSpNZF2vGjyE3Y7c9OFSA3DiuwnS0Kpk94dHShqIix_XFHwL-kTr2JPeGgxOEvjPVyQlJdtuaCWpEd0ijNMtuqoIsgjGQkCVtRjSABo0FdzVv_durUzFs2EtReF2deaOesn4vP6LM1w_f0UHQcEI_TqU0jhzar2cIJZyT4tJCIZq0Om1w" http://localhost:9090/hello
