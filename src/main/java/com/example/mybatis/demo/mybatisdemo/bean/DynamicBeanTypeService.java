package com.example.mybatis.demo.mybatisdemo.bean;

public interface DynamicBeanTypeService<T> {
    String CallMethod(String data, T t);
}
