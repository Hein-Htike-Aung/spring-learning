package com.example.httpbasicdemo.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    // For Good Credentials
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        var authorities = authentication.getAuthorities();

        var authority = authorities.stream()
                // read only authority
                .filter(auth -> auth.getAuthority().equals("read"))
                .findFirst();

        if (authority.isPresent()) {
            response.sendRedirect("/index");
        } else {
            response.sendRedirect("/error");
        }

    }
}
