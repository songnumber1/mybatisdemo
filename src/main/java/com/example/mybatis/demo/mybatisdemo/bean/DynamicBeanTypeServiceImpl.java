package com.example.mybatis.demo.mybatisdemo.bean;

public class DynamicBeanTypeServiceImpl implements DynamicBeanTypeService<DynamicBeanTypeGenericVo> {

    @Override
    public String CallMethod(String data, DynamicBeanTypeGenericVo vo) {
        return vo.getData() + ", " + data;
    }
    
}
