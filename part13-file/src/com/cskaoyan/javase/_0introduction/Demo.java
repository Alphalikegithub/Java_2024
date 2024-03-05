package com.cskaoyan.javase._0introduction;

import org.junit.Test;

/**
 * @program: Java_2024
 * @description: File类的引入
 * @create: 2024-03-04 16:58
 **/

public class Demo {
    public static void main(String[] args) {
        System.out.println("hello world!");
        //查看相对路径
        String property = System.getProperty("user.dir");
        System.out.println(property);
        //在Java代码中定义目录需要用"\\"
        String path = "D:\\app2";
    }

}
