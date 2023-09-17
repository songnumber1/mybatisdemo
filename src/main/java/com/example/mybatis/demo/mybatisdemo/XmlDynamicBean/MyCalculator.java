package com.example.mybatis.demo.mybatisdemo.XmlDynamicBean;

import lombok.Data;

@Data
public class MyCalculator {
    Calculcator calculator;
    private int firstNum;
    private int secondNum;

    public void plus() {
        calculator.add(firstNum, secondNum);
    }

    public void substract() {
        calculator.sub(firstNum, secondNum);
    }

    public void multiply() {
        calculator.mul(firstNum, secondNum);
    }

    public void divide() {
        calculator.div(firstNum, secondNum);
    }
}
