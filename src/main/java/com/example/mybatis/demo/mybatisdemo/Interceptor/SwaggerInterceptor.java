package com.example.mybatis.demo.mybatisdemo.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SwaggerInterceptor implements HandlerInterceptor {
    @Override
    @SuppressWarnings("unused")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        final String token = request.getHeader("jwt");
        
        // request.setAttribute("userID", jwtTokenProvider.getId(token));
        return true;
    }
}