package com.example.mybatis.demo.mybatisdemo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
	@Bean
	public FilterRegistrationBean<tokenFilter> tokenFilter(){
		FilterRegistrationBean<tokenFilter> bean = new FilterRegistrationBean<tokenFilter>(new tokenFilter());
		bean.addUrlPatterns("/api/*");
		bean.setOrder(1);
		
		return bean;
	}
}
