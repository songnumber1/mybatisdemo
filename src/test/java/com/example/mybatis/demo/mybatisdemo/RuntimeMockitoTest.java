
package com.example.mybatis.demo.mybatisdemo;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.example.mybatis.demo.mybatisdemo.runtime.RuntimeService;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@Import({RuntimeTestConfig.class})
public class RuntimeMockitoTest {
    @Autowired
    @SuppressWarnings("rawtypes")
    private RuntimeService runtimeService;

    @BeforeEach
    public void setUp() {
    }
    
    @Test
    @DisplayName("MockitoRuntimeServiceImpl1CallMethod")
    @SuppressWarnings({ "unchecked", "unused" })
    void MockitoRuntimeServiceImpl1CallMethod() {
        String result = this.runtimeService.CallMethod("1234");

        assertTrue(true);
        // var returnData = "RumtimeServiceImpl1.CallMethod()";

        // // given
        // // CallMethod를 호출 시 RumtimeServiceImpl1.CallMethod()으로 리턴값을 설정
        // when(runtimeService.CallMethod("")).thenReturn(returnData);

        // // when
        // // stub에서 CallMtthod("1")로 호출 시에는 result값과 동일한 값이 출력되지 않으니 파라미터까지 모두 동일해아한다.
        // String result = this.runtimeService.CallMethod("");

        // // then
        // verify(runtimeService, times(1)).CallMethod("");

        // // then
        // assertTrue(returnData == result);
    }

    @Test
    @DisplayName("BDDMockitoRuntimeServiceImpl1CallMethod")
    @SuppressWarnings("unchecked")
    void BDDMockitoRuntimeServiceImpl1CallMethod() {
        var returnData = "RumtimeServiceImpl1.CallMethod()";
        
        // given
        given(runtimeService.CallMethod("")).willReturn(returnData);

        // when
        String result = runtimeService.CallMethod("");

        // then
        verify(runtimeService, times(1)).CallMethod("");
        // then
        assertTrue(returnData == result);
	}
}
