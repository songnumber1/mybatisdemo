package com.example.mybatis.demo.mybatisdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/api/home")
    public String home() throws InterruptedException {
        Thread.sleep(3000);
        return "home";
    }
}
