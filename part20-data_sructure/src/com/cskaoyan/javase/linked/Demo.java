package com.cskaoyan.javase.linked;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 链表
 * @since 2024-05-23 15:38
 **/

public class Demo {
    public static void main(String[] args) {
        Person ff = new Person("爸爸");
        Person f = new Person("爸爸");
        Person m = new Person("我");
        Person s = new Person("孩子");

        ff.son = f;
        f.son = m;
        m.son = s;

    }
}

class Person{
    String name;
    Person son;

    public Person(String name) {
        this.name = name;
    }
}