package com.example.mybatis.demo.mybatisdemo.runtime;


import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import com.example.mybatis.demo.mybatisdemo.runtime.RuntimeProperties.Service;

@Configuration
public class RuntimeConfig {
    @SuppressWarnings("unused")
    private final ApplicationContext context;

    private final DefaultListableBeanFactory factory;

    private final RuntimeProperties runtimeProperties;

    @SuppressWarnings("rawtypes")
    private RuntimeServiceDb runtimeServiceDb;

    @SuppressWarnings({ "rawtypes", "unchecked"})
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

            // db user 정보 출력
            // if (serviceName.equals("runtime-dbservice")) {
            //     this.runtimeServiceDb = (RuntimeServiceDb) factory.getBean("runtime-dbservice");

            //     var userList = runtimeServiceDb.CallMethod(null);

            //     if (userList != null && userList.size() > 0) {
            //         var users = (List<RuntimeUserVo>)userList.get("users");

            //         if (!users.get(0).getEmail().equals("songnumber1@naver.com")) {
            //             try {
            //                 throw new Exception(HttpStatus.UNAUTHORIZED.getReasonPhrase());
            //             } catch (Exception e) {
            //                 e.printStackTrace();
            //             }
            //         }
            //     }

            //     // System.out.println(userList);
            // }
        }
    }
}
