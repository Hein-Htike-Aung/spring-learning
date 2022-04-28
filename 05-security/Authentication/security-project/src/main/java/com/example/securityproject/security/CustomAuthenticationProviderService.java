package com.example.securityproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationProviderService implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    @Lazy
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    @Lazy
    private SCryptPasswordEncoder sCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // username and password came form UI
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // check user with its username by using CustomUserDetailsService
        CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(username);

        // check Encryption algorithm
        switch (customUserDetails.getUser().getAlgorithm()) {
            case BCRYPT:
                // get Authentication
                return checkPassword(customUserDetails, password, bCryptPasswordEncoder);
            case SCRYPT:
                // get Authentication
                return checkPassword(customUserDetails, password, sCryptPasswordEncoder);
        }

        throw new BadCredentialsException("There is something wrong!");

    }
    // check password by using PasswordEncoder
    private Authentication checkPassword(CustomUserDetails user, String password, PasswordEncoder passwordEncoder) {

        // user.getPassword() -> Old Password
        // password came from UI
        if (passwordEncoder.matches(password, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        } else {
            throw new BadCredentialsException("Password is incorrect.");
        }
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }


}
