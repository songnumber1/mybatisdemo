package com.example.mybatis.demo.mybatisdemo.XmlDynamicBean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Configuration
@ConfigurationProperties(prefix = "bean.management.xml.properties")
public class XmlDynamicConfig extends XmlDynamicConfigBase {
    private String mycalculator;

    private String test;

    @Override
    public void afterPropertiesSet() throws Exception {
        // 싱글톤으로 객체 생성되지만 this.context == null 방어 코드
        if (this.context == null) {
            String configLocation = "classpath:applicationContext.xml";

            this.context = new ClassPathXmlApplicationContext(configLocation);
        }
    }
}
