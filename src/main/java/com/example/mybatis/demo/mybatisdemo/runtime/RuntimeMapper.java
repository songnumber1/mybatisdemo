package com.example.mybatis.demo.mybatisdemo.runtime;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RuntimeMapper {
    List<RuntimeUserVo> selectUsers();
}
