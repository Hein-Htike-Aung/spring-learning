package com.example.jksresourceserver.config;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

public class AdditionalClaimsAccessTokenConvector extends JwtAccessTokenConverter {
    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {

        var oAuth2Authentication = super.extractAuthentication(map);

        oAuth2Authentication.setDetails(map);

        return oAuth2Authentication;
    }
}
