package com.example.mybatis.demo.mybatisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis.demo.mybatisdemo.XmlDynamicBean.MyCalculator;
import com.example.mybatis.demo.mybatisdemo.XmlDynamicBean.XmlDynamicConfig;
import com.example.mybatis.demo.mybatisdemo.sample.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class TestController1 implements ControllerBase {
    @Autowired
    private UserService userService;

    @Autowired
    private XmlDynamicConfig xmlDynamicConfig;

    private MyCalculator myCalculator;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.myCalculator = (MyCalculator) xmlDynamicConfig.getBean(MyCalculator.class,
                xmlDynamicConfig.getMycalculator());
    }
    
    // @Autowired
    // TestController1(UserService userService, XmlDynamicConfig xmlDynamicConfig) {
    //     this.userService = userService;
    //     this.xmlDynamicConfig = xmlDynamicConfig;
    //     this.myCalculator = (MyCalculator) xmlDynamicConfig.getBean(MyCalculator.class, xmlDynamicConfig.getMycalculator());
    // }

    @GetMapping("/setAnnotation1/{data}")
    public void setAnnotation(@PathVariable int data) {
        System.out.println("setAnnotation1 Before : " + userService.GetAnnotationData());

        userService.SetAnnotationData(data);

        System.out.println("setAnnotation1 : " + userService.GetAnnotationData());
    }

    @GetMapping("/dynamicXmlBeanTest1/{data}")
    public String dynamicXmlBeanTest(@PathVariable String data) {
        MyCalculator mClass = (MyCalculator) xmlDynamicConfig.getBean(MyCalculator.class,
                xmlDynamicConfig.getMycalculator());

        int firstNum = mClass.getFirstNum();
        int secondNum = mClass.getSecondNum();

        mClass.setFirstNum(firstNum * 2);
        mClass.setSecondNum(secondNum * 2);

        mClass.plus();

        return "dynamicXmlBeanTest1 : data";
    }
    
    @GetMapping("/dynamicXmlBeanTest2/{data}")
    public String dynamicXmlBeanTest2(@PathVariable String data) throws Exception {
        this.xmlDynamicConfig.afterPropertiesSet();

        int firstNum = this.myCalculator.getFirstNum();
        int secondNum = this.myCalculator.getSecondNum();

        this.myCalculator.setFirstNum(firstNum * 2);
        this.myCalculator.setSecondNum(secondNum * 2);

        this.myCalculator.plus();

        return "dynamicXmlBeanTest2 : data";
    }
}