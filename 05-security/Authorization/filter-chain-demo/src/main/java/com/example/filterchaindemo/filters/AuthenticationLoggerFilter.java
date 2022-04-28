package com.example.filterchaindemo.filters;

import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationLoggerFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(AuthenticationLoggerFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        var httpRequest = (HttpServletRequest) servletRequest;

        String requestId = httpRequest.getHeader("Request-Id");

        logger.info("Authenticated request with Request-Id -> " + requestId);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
