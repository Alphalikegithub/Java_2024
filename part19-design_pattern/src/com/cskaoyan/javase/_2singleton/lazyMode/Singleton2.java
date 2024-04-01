package com.cskaoyan.javase._2singleton.lazyMode;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 线程安全的懒加载
 * @since 2024-03-18 21:34
 **/

public class Singleton2 {
    //提供自身类型的全局的成员变量
    private static Singleton2 instance;

    //构造方法私有
    private Singleton2() {

    }

    //提供静态方法，返回实例
    // 加关键字synchronized使用同步方法 可以实现原子操作，保证线程安全
    public static synchronized Singleton2 getInstance() {
        //为了一次只创建一个对象
        //在判断instance是否为null时可能会发生线程间的切换，导致对象创建两次。所以叫做不安全的懒加载
        if (instance == null) {
            //赋值
            instance = new Singleton2();
        }
        //直接return instance是错误的
        return instance;
    }
}
