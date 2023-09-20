package com.example.mybatis.demo.mybatisdemo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
	public FilterRegistrationBean<ApiKeyFilter> filter1(){
		FilterRegistrationBean<ApiKeyFilter> bean = new FilterRegistrationBean<>(new ApiKeyFilter());
		bean.addUrlPatterns("/api/*");
		bean.setOrder(1);
		
		return bean;
	}
}
