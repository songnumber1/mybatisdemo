package com.example.mybatis.demo.mybatisdemo;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.example.mybatis.demo.mybatisdemo.runtime.RuntimeService;
import com.example.mybatis.demo.mybatisdemo.runtime.RuntimeServiceImpl1;

@TestConfiguration
public class RuntimeTestConfig {
    @Bean
    @Primary
    @SuppressWarnings("rawtypes")
    public RuntimeService testRuntimeService() {
        return new RuntimeServiceImpl1();
    }
}
