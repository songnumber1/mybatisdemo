package com.example.mybatis.demo.mybatisdemo.runtime;

import java.util.Map;

public interface RuntimeServiceDb<T> {
    Map<String, Object> CallMethod(T param);
}
