package com.example.mybatis.demo.mybatisdemo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiKeyFilter implements Filter {

    @Value("${bearer.authentication.header.key:Authentication}")
    private String bearerKey = "Authentication";

    private final String TEST_KEY = "bearer";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("필터1");
        // chain.doFilter(request, response);
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String key = httpRequest.getHeader(bearerKey);

        if (!TEST_KEY.equals(key)) {
            ObjectMapper mapper = new ObjectMapper();
            httpResponse.getWriter()
                    .write(mapper.writeValueAsString("The API key was not found or not the expected value."));
            httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        chain.doFilter(request, response);
    }
}
