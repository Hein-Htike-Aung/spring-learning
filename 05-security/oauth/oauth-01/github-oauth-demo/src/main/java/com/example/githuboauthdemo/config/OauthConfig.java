package com.example.githuboauthdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class OauthConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {

        return new InMemoryClientRegistrationRepository(clientRegistration());
    }

    private ClientRegistration clientRegistration() {

        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("390ce4f0795e62afbd40")
                .clientSecret("ee43cf34808a65e0dc055c54bf83f136428517a7")
                .build();
    }
}
