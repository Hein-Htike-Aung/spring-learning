package com.example.businesslogicserver.authentication.filter;

import com.example.businesslogicserver.authentication.OtpAuthentication;
import com.example.businesslogicserver.authentication.UsernamePasswordAuthentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class InitialAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Value("${jwt.signing.key}")
    private String signingKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String username = request.getHeader("username");
        String password = request.getHeader("password");
        String code = request.getHeader("code");

        if (code == null) {
            UsernamePasswordAuthentication authentication = new UsernamePasswordAuthentication(username, password);

            // go to UsernamePasswordAuthenticationProvider.authenticate()
            authenticationManager.authenticate(authentication);
        } else {

            OtpAuthentication authentication = new OtpAuthentication(username, code);

            // go to OtpAuthenticationProvider.authenticate()
            authenticationManager.authenticate(authentication);

            // Create jwt Key
            SecretKey key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));

            String jwt = Jwts.builder()
                    // jwt's body
                    .setClaims(Map.of("username", username))
                    // jwt's signature
                    .signWith(key)
                    .compact();

            // set Response's Header with jwt key
            response.setHeader("Authorization", jwt);


        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

        // Going to filter out on login page
        return !request.getServletPath().equals("/login");
    }
}
