package com.example.mybatis.demo.mybatisdemo.runtime;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuntimeController {
    private ApplicationContext context;

    DefaultListableBeanFactory factory;

    private String beanName;

    @Autowired
    public RuntimeController(ApplicationContext context) {
        this.context = context;
        this.factory = (DefaultListableBeanFactory) ((ConfigurableApplicationContext) context).getBeanFactory();
    }
    
    @GetMapping("/api/v1/runtime/setdata/{data}")
    public String setRuntimeData(@PathVariable String data) {
        // get BeanFactory from ApplicationContext
        GenericBeanDefinition gbd = new GenericBeanDefinition();

        if (data.equals("RuntimeServiceImpl1")) {
            if (factory.containsBean("RuntimeServiceImpl1")) {
                factory.removeBeanDefinition("RuntimeServiceImpl1");
            }
            else {
                // 멤버 필드 값 셋팅
                // MutablePropertyValues propertyValues = new MutablePropertyValues();
                // propertyValues.addPropertyValue("prop1", "prop1");
                // propertyValues.addPropertyValue("prop2", "prop2");

                // bean 생성
                GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
                beanDefinition.setBeanClass(RuntimeServiceImpl1.class);
                beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
                // beanDefinition.setPropertyValues(propertyValues);

                // factory에 bean 등록
                factory.registerBeanDefinition("RuntimeServiceImpl1", beanDefinition);   
            }
        } else {
            if (factory.containsBean("RuntimeServiceImpl2")) {
                factory.removeBeanDefinition("RuntimeServiceImpl2");
            }
            else {
                // 멤버 필드 값 셋팅
                // MutablePropertyValues propertyValues = new MutablePropertyValues();
                // propertyValues.addPropertyValue("prop1", "prop1");
                // propertyValues.addPropertyValue("prop2", "prop2");

                // bean 생성
                GenericBeanDefinition beanDefinition = new GenericBeanDefinition();

                beanDefinition.setBeanClass(RuntimeServiceImpl2.class);
                beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
                // beanDefinition.setPropertyValues(propertyValues);

                // factory에 bean 등록
                factory.registerBeanDefinition("RuntimeServiceImpl2", beanDefinition);
            }
        }

        this.beanName = data;

        return "OK";
    }
    
    @GetMapping("/api/v1/runtime/bean/run")
    public String setRuntimeData() {
        if (this.beanName.equals("RuntimeServiceImpl1")) {
            RuntimeServiceImpl1 RuntimeServiceImpl1 = context.getBean(RuntimeServiceImpl1.class);

            return RuntimeServiceImpl1.CallMethod();
        } else {
            RuntimeServiceImpl2 RuntimeServiceImpl2 = context.getBean(RuntimeServiceImpl2.class);

            return RuntimeServiceImpl2.CallMethod();
        }        
    }
}
