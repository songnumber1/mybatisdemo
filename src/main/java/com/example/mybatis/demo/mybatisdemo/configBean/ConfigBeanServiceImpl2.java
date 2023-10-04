package com.example.mybatis.demo.mybatisdemo.configBean;

public class ConfigBeanServiceImpl2 implements ConfigBeanService<String, ConfigBeanVo> {

    @Override
    public ConfigBeanVo CallMethod(String data) {
        ConfigBeanVo vo = new ConfigBeanVo();
        vo.setId(data);

        return vo;
    }
}
