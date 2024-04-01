package com.cskaoyan.javase._2singleton.hungryMode;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 线程安全的立即加载
 * @since 2024-03-18 21:16
 **/

/**
 * 单例模式的实现方式
 * 构造方法私有
 * 提供静态方法，返回实例
 * 提供自身类型的全局的成员变量
 */
public class Singleton4 {
    //提供自身类型的全局的成员变量
    private static Singleton4 instance = new Singleton4();

    //构造方法私有
    private Singleton4() {

    }

    //提供静态方法，返回实例
    public static Singleton4 getInstance() {
        //最终目的是返回实例
        return instance;
    }
}

