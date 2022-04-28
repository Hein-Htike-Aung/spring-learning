package com.example.rolesbasedspringmvcsecurity.security.filter;

import com.example.rolesbasedspringmvcsecurity.security.SecurityRoles;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;
import java.util.Collections;

// CustomizedRequestParamAuthenticationFilter will be comprised in SecurityFilterChain
public class CustomizedRequestParamAuthenticationFilter extends GenericFilter {

    public static final String ADMIN_SECRET_AUTH_TOKEN = "ADMIN_SECRET_AUTH_TOKEN";

    // http://localhost:8080/employees?X-AUTH-TOKEN=ADMIN_SECRET_AUTH_TOKEN
    // http://localhost:8080/departments?X-AUTH-TOKEN=ADMIN_SECRET_AUTH_TOKEN
    // http://localhost:8080/customers?X-AUTH-TOKEN=ADMIN_SECRET_AUTH_TOKEN
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        SecurityContext securityContext = SecurityContextHolder.getContext();

        if (ADMIN_SECRET_AUTH_TOKEN.equals(servletRequest.getParameter("X-AUTH-TOKEN")) && null != securityContext) {

            securityContext.setAuthentication(

                    // New Authentication
                    new AnonymousAuthenticationToken(
                            "x-auth", "X-ADMIN",
                            Collections.singletonList(
                                    new SimpleGrantedAuthority(SecurityRoles.ROLE_PREFIX + SecurityRoles.SUPER_ADMIN)
                            )
                    )
            );


        }

        // Go to Next Filter
        filterChain.doFilter(servletRequest, servletResponse);


    }

}
