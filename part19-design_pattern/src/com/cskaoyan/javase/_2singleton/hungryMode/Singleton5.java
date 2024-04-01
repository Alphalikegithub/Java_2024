package com.cskaoyan.javase._2singleton.hungryMode;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 外部类
 * @since 2024-03-18 22:19
 **/

public class Singleton5 {
    //提供自身的全局的成员变量
    private static Singleton5 instance;
    //私有的构造方法
    private Singleton5(){

    }

    //外部类访问内部类的方法
    static Singleton5 getInstance(){
        //调用内部类的静态方法
        Singleton5 instance1 = Inner.getInstance();
        return instance1;
    }
    static class Inner{
        //内部类的静态代码块
        static {
            //完成对instance的赋值操作
            instance = new Singleton5();
        }
        static Singleton5 getInstance(){
            //返回这个instance 需要被赋值
            return instance;
        }
    }
}
