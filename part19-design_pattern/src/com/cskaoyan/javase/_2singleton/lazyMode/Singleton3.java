package com.cskaoyan.javase._2singleton.lazyMode;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 使用synchronized同步代码块
 * @since 2024-03-18 21:43
 **/

public class Singleton3 {
    private static Singleton3 instance;
    private Singleton3(){

    }
    //提供静态方法，返回实例
    public static Singleton3 getInstance(){
        //第一次check
        if(instance == null){
            synchronized (Singleton3.class){
                //第二次check
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
