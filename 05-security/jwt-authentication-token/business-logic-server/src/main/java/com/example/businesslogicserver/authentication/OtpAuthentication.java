package com.example.businesslogicserver.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class OtpAuthentication extends UsernamePasswordAuthenticationToken {

    // principal is username, credentials is code
    public OtpAuthentication(Object principal, Object credentials) {
        super(principal, credentials);
    }


}
