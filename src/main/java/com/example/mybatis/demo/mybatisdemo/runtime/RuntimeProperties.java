package com.example.mybatis.demo.mybatisdemo.runtime;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("bean")
@Data
public class RuntimeProperties {
    List<Service> services;

    @Data
    public static class Service {
        String name;
        String type;
    }
}
