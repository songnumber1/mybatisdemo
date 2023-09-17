package com.example.mybatis.demo.mybatisdemo.Management.Properties;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.example.mybatis.demo.mybatisdemo.Management.Factory.TestFactory;

import lombok.Data;

@ConfigurationProperties(prefix = "bean.management.properties")
@Data
public class TestProperties implements InitializingBean {
    @Autowired
    private TestFactory testFactory;

    private String item;

    public void initMethod() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        System.out.println("initMethod item : " + item);

        // testFactory.createManager();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct item : " + item);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet item : " + item);
    }
}
