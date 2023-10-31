package com.example.mybatis.demo.mybatisdemo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
	public FilterRegistrationBean<ApiSwaggerV1KeyFilter> swaggerV1Filter() {
		FilterRegistrationBean<ApiSwaggerV1KeyFilter> bean = new FilterRegistrationBean<>(new ApiSwaggerV1KeyFilter());
		bean.addUrlPatterns("/api/v1/swagger/*");
		bean.setOrder(1);

		return bean;
	}
	
	@Bean
	public FilterRegistrationBean<ApiSwaggerV2KeyFilter> swaggerV2Filter(){
		FilterRegistrationBean<ApiSwaggerV2KeyFilter> bean = new FilterRegistrationBean<>(new ApiSwaggerV2KeyFilter());
		bean.addUrlPatterns("/api/v2/swagger/*");
		bean.setOrder(1);
		
		return bean;
	}
}
