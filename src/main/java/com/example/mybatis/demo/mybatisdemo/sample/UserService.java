package com.example.mybatis.demo.mybatisdemo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    
    private int annotationData = 0;

    public void SetAnnotationData(int i) {
        this.annotationData = i;
    }

    public int GetAnnotationData() {
        return this.annotationData;
    }

    @Autowired
    private UserDao userDao;

    public List<HashMap<String, Object>> getUsers() {
        return userMapper.selectUsers();
    }

    public List<HashMap<String, Object>> getUsersWithDao() {
        return userDao.getUsers();
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }
}
