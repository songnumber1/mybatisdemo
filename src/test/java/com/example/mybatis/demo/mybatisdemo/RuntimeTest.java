package com.example.mybatis.demo.mybatisdemo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.mybatis.demo.mybatisdemo.runtime.RuntimeService;

@ExtendWith(MockitoExtension.class)
// @Import({RuntimeTestConfig.class})
public class RuntimeTest {
    
    @Mock
    @SuppressWarnings("rawtypes")
    private RuntimeService runtimeService;

    @Test
    @DisplayName("RuntimeServiceImpl1CallMethod")
    @SuppressWarnings("unchecked")
    void RuntimeServiceImpl1CallMethod() {
        // given
        var returnData = "RumtimeServiceImpl1.CallMethod()";

        // when
        when(runtimeService.CallMethod("")).thenReturn("RumtimeServiceImpl1.CallMethod()");

        // stub
        String result = this.runtimeService.CallMethod("");

        // then
        assertTrue(returnData == result);
	}
}
