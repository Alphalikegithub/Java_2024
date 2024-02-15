package com.cskaoyan.javase.oop2._2extends._4initalization;

/**
 * @program: Java_2024
 * @description: 子类对象的初始化
 * @create: 2024-01-17 15:14
 **/
//创建子类对象或者触发子类的类加载，应该先加载它的父类
//类加载结束后要明确只会创建一个子类对象，不会创建父类对象

/*两种子类对象初始化的方式
1.子类对象的隐式初始化
* 没用this或super去调用其他构造器时，永远隐含一行代码super()*/
public class Demo {
    public static void main(String[] args) {

        Star star = new Star("haha");
    }
}

class Person {
    static {
        System.out.println("Person类加载");
    }

    String name;

    public void eat() {
        System.out.println("我想吃饭");
    }
}

class Star extends Person {
    static {
        System.out.println("Star类加载");
    }

    String stageName;

    public Star(String stageName) {
        this.stageName = stageName;
    }

    public void sing() {
        System.out.println("来一首爱的供养");
    }
}