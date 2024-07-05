package com.cskaoyan.javase.generic;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 泛型通配符
 * @since 2024-07-05 09:42
 **/

public class DemoGeneric1 {
    /*
    * 泛型通配符<?>
    任意类型，如果没有明确，那么就是Object以及任意的Java类了
    * ? extends E
    向下限定，可以指代E类型 及E的子类型
    * ? super E
    向上限定，可以指代E类型 及E的父类
    * */
    public static void main(String[] args) {

    }
}
class F{}
class S1 extends F{}
class S2 extends F{}