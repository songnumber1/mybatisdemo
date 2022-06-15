package com.example.mybatis.demo.mybatisdemo.sample;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<HashMap<String, Object>> selectUsers();

    @Select("SELECT * FROM user")
    List<User> findAll();
}
