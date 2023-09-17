package com.example.mybatis.demo.mybatisdemo.XmlDynamicBean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

import lombok.Data;

@Data
public abstract class XmlDynamicConfigBase implements InitializingBean {
    protected ApplicationContext context;

    public Object getBean(Class<?> beanClass, String name) {
        return context.getBean(name, beanClass);
    }

    public Object getBean(Class<?> beanClass) {
        return context.getBean(beanClass);
    }
}
