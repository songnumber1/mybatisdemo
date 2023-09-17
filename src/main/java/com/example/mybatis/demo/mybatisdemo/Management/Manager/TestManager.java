package com.example.mybatis.demo.mybatisdemo.Management.Manager;

public class TestManager {
    private String item;

    private int item1;

    public TestManager() {

    }
    
    public String CallMethod(String item) {
        this.item1 = this.item1 + 100;

        this.item = item;
        return "TestManager.CallMethod item : " + this.item;
    }
}
