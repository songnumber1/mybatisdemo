package com.example.mybatis.demo.mybatisdemo.runtime;

public class RuntimeServiceImpl2 implements RuntimeService<Integer> {
    @Override
    public String CallMethod(Integer param) {
        return "RumtimeServiceImpl2.CallMethod() : " + String.valueOf(param);
    }   
}
