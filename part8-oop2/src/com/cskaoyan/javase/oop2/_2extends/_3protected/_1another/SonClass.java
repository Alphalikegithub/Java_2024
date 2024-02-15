package com.cskaoyan.javase.oop2._2extends._3protected._1another;

import com.cskaoyan.javase.oop2._2extends._3protected._0one.Demo;

/**
 * @program: Java_2024
 * @description: 不同包下的子类
 * @create: 2024-01-17 11:43
 **/

public class SonClass extends Demo {
    public static void main(String[] args) {
        Demo demo3 = new Demo();
        //'a' has protected access in 'com.cskaoyan.javase.oop2._2extends._3protected._0one.Demo'
        //System.out.println(demo3.a);
        SonClass son = new SonClass();
        //protected int a

        System.out.println(son.a);
    }
}
