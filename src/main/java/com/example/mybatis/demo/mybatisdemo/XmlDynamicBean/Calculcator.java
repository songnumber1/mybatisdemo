package com.example.mybatis.demo.mybatisdemo.XmlDynamicBean;

public class Calculcator  {
    public void add(int firstNum, int secondNum) {
        System.out.println("add = " + (firstNum + secondNum));
    }

    public void sub(int firstNum, int secondNum) {
        System.out.println("sub = " + (firstNum - secondNum));
    }

    public void mul(int firstNum, int secondNum) {
        System.out.println("mul = " + (firstNum * secondNum));
    }

    public void div(int firstNum, int secondNum) {
        System.out.println("div = " + (firstNum / secondNum));
    }
}
