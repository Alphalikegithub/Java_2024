package com.cskaoyan.javase.oop1._17singleton;

/**
 * @program: Java_2024
 * @description: 单例模式
 * @create: 2024-01-16 23:00
 **/
//懒汉模式：只有在确定要使用这个类对象时，才创建这个对象
//饿汉模式:在一开始就直接创建该类对象，无需在使用它时再创建
public class Demo {
    public static void main(String[] args) {
        Test t1 = Test.getInstance();
        Test t2 = Test.getInstance();

        Test2 t12 = Test2.getInstance();
        Test2 t22 = Test2.getInstance();
    }
}

//懒汉模式
class Test {
    private static Test t = null;
    private int testInt;
    private String testString;

    public static Test getT() {
        return t;
    }

    public int getTestInt() {
        return testInt;
    }

    //类的构造器必须是私有的
    private Test() {
    }

    //在类中写一个静态成员方法，用于获取该类的对象
    //该方法不能直接返回new 对象
    //所以将自身类对象的引用对象作为自身的静态成员变量,然后返回它
    public static Test getInstance() {
//懒汉模式
        if (t != null) {
            return t;
        }
        //如果类对象t不存在
        t = new Test();
        return t;
    }

    public String getTestString() {
        return testString;
    }
}

//饿汉模式
class Test2 {
    private static Test2 t = null;

    private Test2() {
    }

    public static Test2 getInstance() {
        return t;
    }
}