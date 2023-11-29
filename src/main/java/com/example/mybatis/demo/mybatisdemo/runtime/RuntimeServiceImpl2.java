package com.example.mybatis.demo.mybatisdemo.runtime;

public class RuntimeServiceImpl2 implements RuntimeService<Integer> {
    @Override
    public String CallMethod(Integer param) {
        int[] a = new int[1];
        a[2] = 1;
        
        return "RumtimeServiceImpl2.CallMethod() : " + String.valueOf(param);
    }   
}
