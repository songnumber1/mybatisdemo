package com.example.mybatis.demo.mybatisdemo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanManager {
    @Value("${bean.config.dynamicbean}")
    String dynamicBean;

    @Value("${bean.config.dynamictypebean}")
    String dynamicTypeBean;

    @Bean
    @ConditionalOnProperty(value = "bean.config.dynamicbean.enable", havingValue = "true", matchIfMissing = false)
    public DynamicBeanService GetDynamicBean()
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        DynamicBeanService obj = (DynamicBeanService) Class.forName(dynamicBean).newInstance();

        return obj;
    }
    
    @SuppressWarnings("unchecked")
    @Bean
    @ConditionalOnProperty(value = "bean.config.dynamictypebean.enable", havingValue = "true", matchIfMissing = false)
    public DynamicBeanTypeService<DynamicBeanTypeGenericVo> GetDynamicTypeBean()
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        DynamicBeanTypeService<DynamicBeanTypeGenericVo> obj = (DynamicBeanTypeService<DynamicBeanTypeGenericVo>) Class
                .forName(dynamicTypeBean).newInstance();

        return obj;
    }
}
