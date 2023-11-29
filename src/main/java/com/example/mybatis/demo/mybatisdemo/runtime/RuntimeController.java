package com.example.mybatis.demo.mybatisdemo.runtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// import com.example.mybatis.demo.mybatisdemo.webp.WebpService;


@RestController
@SuppressWarnings("rawtypes")
public class RuntimeController {
    // 동적 bean 설정 시 아래와 같이 방법 2가지 중 하나로 써야한다.
    // @Qualifer은 @Value가 적용되지 않는다.

    // 방법 1
    @Autowired
    @Qualifier("runtime-service1")
    private RuntimeService runtimeService1;

    @Autowired
    @Qualifier("runtime-service2")
    private RuntimeService runtimeService2;

    @Autowired
    private RuntimeServiceDb runtimeServiceDb;


    // ==================================================================

    // 방법 2
    // private final RuntimeService runtimeService1;

    // private final RuntimeService runtimeService2;

    // public RuntimeController(@Qualifier("runtime-service1")  RuntimeService runtimeService1, @Qualifier("runtime-service2")  RuntimeService runtimeService2) {
    //     this.runtimeService1 = runtimeService1;
    //     this.runtimeService2 = runtimeService2;
    // }
    // ==================================================================

    @GetMapping("/api/v1/runtime/service1/{data}")
    @SuppressWarnings("unchecked")
    public String RuntimeServiceCallMethod1(@PathVariable String data) {
        try {
            return runtimeService1.CallMethod(data);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/api/v1/runtime/service2/{data}")
    @SuppressWarnings("unchecked")
    public String RuntimeServiceCallMethod2(@PathVariable Integer data) {
        try {
            return runtimeService2.CallMethod(data);    
        } catch (Exception e) {
            throw e;
        }
        
    }

    @GetMapping("/api/v1/runtime/dbservice/{data}")
    @SuppressWarnings("unchecked")
    public ResponseEntity<?> RuntimeServiceCallMethod3(@PathVariable Integer data) {
        var result = runtimeServiceDb.CallMethod(data);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/axios/test/{data}")
    @SuppressWarnings("unchecked")
    public ResponseEntity<?> RuntimeServiceCallAxios(@PathVariable Integer data) {
        var result = runtimeServiceDb.CallMethod(data);

        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/axios/test/error/{data}")
    public ResponseEntity<?> RuntimeServiceErroCallAxios(@PathVariable Integer data) {
        try {
            String[] a = new String[1];
            a[1] = "1";
            return ResponseEntity.ok(a);
        } catch (Exception e) {
            throw e;
        }
    }

    // @Autowired
    // WebpService webpService;

    // @GetMapping("/api/v1/webp")
    // public String webpConvertBase64() {
    //     return webpService.webpConvertBase64();
    // }
}
