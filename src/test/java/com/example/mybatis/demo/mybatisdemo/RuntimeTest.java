
package com.example.mybatis.demo.mybatisdemo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.example.mybatis.demo.mybatisdemo.runtime.RuntimeService;

@SpringBootTest
@Import({RuntimeTestConfig.class})
public class RuntimeTest {
    @Autowired
    @SuppressWarnings("rawtypes")
    private RuntimeService runtimeService;

    @BeforeEach
    public void setUp() {
    }
    
    @Test
    @DisplayName("RuntimeServiceImpl1CallMethod")
    @SuppressWarnings("unchecked")
    void RuntimeServiceImpl1CallMethod() {
        String result = "RumtimeServiceImpl1.CallMethod() : 1234";

        String returnData = this.runtimeService.CallMethod("1234");

        assertTrue(returnData.equals(result));
    }
}
