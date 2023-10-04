package com.example.mybatis.demo.mybatisdemo.configBean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import lombok.Data;

@Configuration
@Data
public class ConfigBeanManager {
    public static final String configBeanServiceImpl1 = "configBeanServiceImpl1";

    @Bean
    @Qualifier(ConfigBeanManager.configBeanServiceImpl1)
    @Primary
    public ConfigBeanService<String, String> ConfigBeanService1() {
        return new ConfigBeanServiceImpl1();
    }

    public static final String configBeanServiceImpl2 = "configBeanServiceImpl2";

    @Bean
    @Qualifier(ConfigBeanManager.configBeanServiceImpl2)
    public ConfigBeanService<String, ConfigBeanVo> ConfigBeanService2() {
        return new ConfigBeanServiceImpl2();
    }
}
