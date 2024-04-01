package com.cskaoyan.javase._2singleton.lazyMode;

import com.cskaoyan.javase._2singleton.lazyMode.Singleton1;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-18 21:21
 **/

public class SingletonTest {
    public static void main(String[] args) {
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton1 instance2 = Singleton1.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        //打印出的地址不一致 说明是两个不同的对象 不满足单例模式
    }
}
