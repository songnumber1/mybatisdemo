package com.example.mybatis.demo.mybatisdemo.runtime;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.example.mybatis.demo.mybatisdemo.runtime.RuntimeProperties.Service;

@Configuration

public class RuntimeConfig {
    private final ApplicationContext context;

    private final DefaultListableBeanFactory factory;

    private final RuntimeProperties runtimeProperties;

    public RuntimeConfig(ApplicationContext context, RuntimeProperties runtimeProperties) throws ClassNotFoundException {
        this.context = context;
        this.factory = (DefaultListableBeanFactory) ((ConfigurableApplicationContext) context).getBeanFactory();
        this.runtimeProperties = runtimeProperties;

        int a = 1;
        for (Service item : this.runtimeProperties.getServices()) {
            String serviceName = item.getName();
            String serviceType = item.getType();

            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(Class.forName(serviceType));
            beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);

            // 상관없는 코드
            // beanDefinition.setBeanClassName(serviceName);
            // beanDefinition.setFactoryBeanName(serviceName);
            // beanDefinition.addQualifier(new AutowireCandidateQualifier(serviceName));

            // beanDefinition.setPropertyValues(propertyValues);

            // factory에 bean 등록
            factory.registerBeanDefinition(serviceName, beanDefinition);
            a = a + 1;
        }
    }
}
