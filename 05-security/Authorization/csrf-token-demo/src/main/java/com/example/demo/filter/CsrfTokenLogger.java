package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;

import javax.servlet.*;
import java.io.IOException;

public class CsrfTokenLogger implements Filter {

    private Logger logger = LoggerFactory.getLogger(CsrfTokenLogger.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Object o = servletRequest.getAttribute("_csrf");

        CsrfToken csrfToken = (CsrfToken) o;

        logger.info("CSRFToken -> " + csrfToken.getToken());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
