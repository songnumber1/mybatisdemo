package com.example.mybatis.demo.mybatisdemo.runtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("rawtypes")
public class RuntimeController {
    private final RuntimeService runtimeService1;

    private final RuntimeService runtimeService2;    

    @Autowired
    public RuntimeController(@Qualifier("runtime-service1") RuntimeService runtimeService1, @Qualifier("runtime-service2") RuntimeService runtimeService2) {
        this.runtimeService1 = runtimeService1;
        this.runtimeService2 = runtimeService2;
    }
    
    
    @GetMapping("/api/v1/runtime/service1/{data}")
    @SuppressWarnings("unchecked")
    public String RuntimeServiceCallMethod1(@PathVariable String data) {
        return runtimeService1.CallMethod(data);
    }

    @GetMapping("/api/v1/runtime/service2/{data}")
    @SuppressWarnings("unchecked")
    public String RuntimeServiceCallMethod2(@PathVariable Integer data) {
        return runtimeService2.CallMethod(data);
    }
}
