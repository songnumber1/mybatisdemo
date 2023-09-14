package com.example.mybatis.demo.mybatisdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis.demo.mybatisdemo.sample.User;
import com.example.mybatis.demo.mybatisdemo.sample.UserService;


@RestController
public class TestController1 {
    @Autowired
    private UserService userService;

    @GetMapping("/setAnnotation1/{data}")
    public void setAnnotation(@PathVariable int data) {
        System.out.println("setAnnotation1 Before : " + userService.GetAnnotationData());

        userService.SetAnnotationData(data);

        System.out.println("setAnnotation1 : " + userService.GetAnnotationData());
    }
}