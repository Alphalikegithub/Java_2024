package com.cskaoyan.javase.oop2._2extends._2conversion;

/**
 * @program: Java_2024
 * @description: 引用数据类型转换
 * @create: 2024-01-17 10:56
 **/

public class Demo {
    public static void main(String[] args) {
        Son son = new Son();
        Father f = son;
        Father fs = new Son();
        //强制类型转换
        Son s2 = (Son)fs;
    }
}
class  Father{

}
class Son extends Father{

}
