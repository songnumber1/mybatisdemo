package com.example.mybatis.demo.mybatisdemo.MyAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAutowired {
    String getBean() default "1234";
}
