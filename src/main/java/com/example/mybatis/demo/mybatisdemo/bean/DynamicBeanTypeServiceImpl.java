package com.example.mybatis.demo.mybatisdemo.bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.mybatis.demo.mybatisdemo.sample.UserService;

public class DynamicBeanTypeServiceImpl implements DynamicBeanTypeService<DynamicBeanTypeGenericVo> {
    @Autowired
    private UserService userService;

    @Override
    public String CallMethod(String data, DynamicBeanTypeGenericVo vo) {
        return vo.getData() + ", " + data + ", " +  userService.GetAnnotationData();
    }
}
