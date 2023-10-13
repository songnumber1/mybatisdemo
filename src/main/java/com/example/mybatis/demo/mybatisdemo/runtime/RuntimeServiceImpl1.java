package com.example.mybatis.demo.mybatisdemo.runtime;

public class RuntimeServiceImpl1 implements RuntimeService<String> {
    @Override
    public String CallMethod(String param) {
        return "RumtimeServiceImpl1.CallMethod() : " + param;
    }
    
}
