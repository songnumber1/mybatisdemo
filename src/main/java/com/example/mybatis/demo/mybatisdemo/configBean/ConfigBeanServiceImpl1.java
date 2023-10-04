package com.example.mybatis.demo.mybatisdemo.configBean;

public class ConfigBeanServiceImpl1 implements ConfigBeanService<String, String> {

    @Override
    public String CallMethod(String data) {
        return "configBeanServiceImpl1 data : " + data;
    }
    
}
