package com.example.mybatis.demo.mybatisdemo.Management.Factory;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.mybatis.demo.mybatisdemo.Management.Properties.TestProperties;

import lombok.Getter;


@Configuration
@Getter
public class TestFactory implements InitializingBean {
    @Autowired
    private ConfigurableApplicationContext applicationContext;
  
    private TestProperties testProperties;

    @Value("${bean.management.managerbean}")
    String managerBean;

    @Value("${bean.management.managerbean.name}")
    String managerBeanName;

    @Bean(initMethod = "initMethod")
    public TestProperties getTestProperties() {
        this.testProperties = new TestProperties();

        return testProperties;
    }
    
    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        applicationContext.getBeanFactory().registerSingleton(managerBeanName,
                Class.forName(managerBean).getDeclaredConstructor().newInstance());
    }
}