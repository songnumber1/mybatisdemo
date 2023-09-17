package com.example.mybatis.demo.mybatisdemo.bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.mybatis.demo.mybatisdemo.sample.UserService;

public class DynamicBeanServiceImpl implements DynamicBeanService {
    @Autowired
    private UserService userService;
    
    @Override
    public String CallMethod(String data) {
        userService.SetAnnotationData(100);
        return data + ", " + userService.GetAnnotationData();
    }
}
