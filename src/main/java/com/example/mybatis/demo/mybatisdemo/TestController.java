package com.example.mybatis.demo.mybatisdemo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis.demo.mybatisdemo.sample.User;
import com.example.mybatis.demo.mybatisdemo.sample.UserService;


@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<HashMap<String, Object>> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getUsersDao")
    public List<HashMap<String, Object>> getUsersDao() {
        return userService.getUsersWithDao();
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        System.out.println("findAll");
        return userService.findAll();
    }

    @PostMapping("/user/insert")
    public void userInsert(@RequestBody User user) {
        System.out.println(user);
    }
}
