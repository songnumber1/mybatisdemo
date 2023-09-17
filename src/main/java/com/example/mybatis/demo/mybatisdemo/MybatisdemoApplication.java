package com.example.mybatis.demo.mybatisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MybatisdemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MybatisdemoApplication.class, args);
	}
}
