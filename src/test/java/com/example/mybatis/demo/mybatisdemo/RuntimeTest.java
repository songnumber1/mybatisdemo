package com.example.mybatis.demo.mybatisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.util.Assert;

import com.example.mybatis.demo.mybatisdemo.runtime.RuntimeService;

@SpringBootTest
@Import({RuntimeTestConfig.class})
public class RuntimeTest {
    @Autowired
    private RuntimeService runtimeService;

    @Test
	void RuntimeServiceImpl1CallMethod() {
		this.runtimeService.CallMethod("");
		System.out.println("111111");

		Assert.isTrue(true);
	}
}
