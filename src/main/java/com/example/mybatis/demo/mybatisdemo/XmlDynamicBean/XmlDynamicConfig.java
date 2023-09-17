package com.example.mybatis.demo.mybatisdemo.XmlDynamicBean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.Data;

@Configuration
@Data
public class XmlDynamicConfig implements InitializingBean {
    private MyCalculator myCalculator;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        String configLocation = "classpath:applicationContext.xml";
        AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);

        this.myCalculator = getMyCalculatorBean("myCalculator");
        ctx.close();
    }
    
    @SuppressWarnings("unchecked")
    public <T> T getBean(T t, String name) {
        String configLocation = "classpath:applicationContext.xml";
        AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);

        ctx.close();

        return (T) ctx.getBean(name, t);
    }

    public MyCalculator getMyCalculatorBean(String name) {
        String configLocation = "classpath:applicationContext.xml";
        AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
        MyCalculator myCalculator = (MyCalculator) ctx.getBean(name, MyCalculator.class);
        
        ctx.close();

        return myCalculator;
    }
}
