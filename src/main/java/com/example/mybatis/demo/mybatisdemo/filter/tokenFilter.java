package com.example.mybatis.demo.mybatisdemo.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;

public class tokenFilter implements Filter {

    @Value("${bearer.authentication.header.name:API_TICKET}")
    private String bearerName = "API_TICKET";

    private final String BEARER_VALUE = "E687D21D-F035-4F66-BB93-A336B8B267D0";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String token = httpRequest.getHeader(bearerName);

        if (!BEARER_VALUE.equals(token)) {
            try {
                throw new Exception();
            } catch (Exception e) {
            }
            
            return;
        }

        chain.doFilter(request, response);
    }
}

