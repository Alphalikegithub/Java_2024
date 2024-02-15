package com.cskaoyan.javase.oop2._2extends._1relation;

/**
 * @program: Java_2024
 * @description: 继承的引入
 * @create: 2024-01-17 00:00
 **/

public class Demo {
    public static void main(String[] args) {
        Son s = new Son();
        s.testFather();
        Father fson = new Son();
    }
}
class Father{
    public void testFather(){}
}
class Son extends Father{
    public void testSon(){}
}
