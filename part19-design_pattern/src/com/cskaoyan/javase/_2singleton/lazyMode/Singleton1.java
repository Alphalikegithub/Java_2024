package com.cskaoyan.javase._2singleton.lazyMode;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 线程不安全的懒加载
 * @since 2024-03-18 21:16
 **/

/**
 * 单例模式的实现方式
 * 构造方法私有
 * 提供静态方法，返回实例
 * 提供自身类型的全局的成员变量
 */
public class Singleton1 {
    //提供自身类型的全局的成员变量
    private static Singleton1 instance;
    //构造方法私有
    private Singleton1(){

    }
    //提供静态方法，返回实例
    public static Singleton1 getInstance() {
        //为了一次只创建一个对象
        //在判断instance是否为null时可能会发生线程间的切换，导致对象创建两次。所以叫做不安全的懒加载
        if(instance == null){
            //赋值
            instance = new Singleton1();
        }
        return instance;//直接return instance是错误的
    }
}

