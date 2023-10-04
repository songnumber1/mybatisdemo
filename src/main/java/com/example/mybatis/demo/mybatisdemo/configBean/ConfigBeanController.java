package com.example.mybatis.demo.mybatisdemo.configBean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/configbean")
public class ConfigBeanController {
    @Autowired
    @Qualifier(ConfigBeanManager.configBeanServiceImpl1)
    public ConfigBeanService<?, ?> configBeanService1;

    @Autowired
    @Qualifier(ConfigBeanManager.configBeanServiceImpl2)
    public ConfigBeanService<?, ?> configBeanService2;

    @GetMapping("service1/{data}")
    public String getService1(@PathVariable String data) {
        return (String) configBeanService1.CallMethod(data);
    }

    @GetMapping("service2/{data}")
    public ResponseEntity<?> getService2(@PathVariable String data) {
        Map<String, Object> result = new HashMap<>();
        
        var callMethod = configBeanService2.CallMethod(data);

        result.put("result", callMethod);

        return ResponseEntity.ok().body(result);
    }
}
