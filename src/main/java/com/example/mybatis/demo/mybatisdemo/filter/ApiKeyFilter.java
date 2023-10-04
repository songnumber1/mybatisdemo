package com.example.mybatis.demo.mybatisdemo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiKeyFilter implements Filter {

    private String bearerKey = "API_TICKET";

    private final String BEARER_VALUE = "E687D21D-F035-4F66-BB93-A336B8B267D0";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String key = httpRequest.getHeader(bearerKey);

        // if (!BEARER_VALUE.equals(key)) {
        //     ObjectMapper mapper = new ObjectMapper();
        //     httpResponse.getWriter()
        //             .write(mapper.writeValueAsString("The API key was not found or not the expected value."));
        //     httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        //     return;
        // }

        chain.doFilter(request, response);
    }
}
