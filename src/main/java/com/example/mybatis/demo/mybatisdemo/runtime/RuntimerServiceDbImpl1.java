package com.example.mybatis.demo.mybatisdemo.runtime;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class RuntimerServiceDbImpl1 implements RuntimeServiceDb {

    private final RuntimeMapper runtimeMapper;

    public RuntimerServiceDbImpl1(RuntimeMapper runtimeMapper) {
        this.runtimeMapper = runtimeMapper;
    }

    @Override
    public Map<String, Object> CallMethod(Object param) {
        var userList = runtimeMapper.selectUsers();

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("users", userList);

        return result;
    }
}
