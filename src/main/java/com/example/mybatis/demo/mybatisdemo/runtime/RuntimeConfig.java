package com.example.mybatis.demo.mybatisdemo.runtime;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.example.mybatis.demo.mybatisdemo.runtime.RuntimeProperties.Service;

@Configuration

public class RuntimeConfig {
    @SuppressWarnings("unused")
    private final ApplicationContext context;

    private final DefaultListableBeanFactory factory;

    private final RuntimeProperties runtimeProperties;

    public RuntimeConfig(ApplicationContext context, RuntimeProperties runtimeProperties) throws ClassNotFoundException {
        this.context = context;
        this.factory = (DefaultListableBeanFactory) ((ConfigurableApplicationContext) context).getBeanFactory();
        this.runtimeProperties = runtimeProperties;

        for (Service item : this.runtimeProperties.getServices()) {
            String serviceName = item.getName();
            String serviceType = item.getType();

            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(Class.forName(serviceType));
            beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);

            // factory에 bean 등록
            factory.registerBeanDefinition(serviceName, beanDefinition);
        }
    }
}
