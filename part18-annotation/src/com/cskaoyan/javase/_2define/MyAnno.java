package com.cskaoyan.javase._2define;
//自定义注解
public @interface MyAnno {
    //属性类型 属性名（）
    int age();
    double price();
    String name();
    String[] names();
    Class c();
}
