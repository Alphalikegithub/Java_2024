package com.cskaoyan.javase._3throw;

import static com.cskaoyan.javase._1handle.Demo1.func;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-02-29 23:43
 **/

public class Demo {
    public static void main(String[] args) {
        func();
    }
    private static void func(){
        //throw关键字
        throw new RuntimeException("抛出了一个运行时异常");
    }
}
