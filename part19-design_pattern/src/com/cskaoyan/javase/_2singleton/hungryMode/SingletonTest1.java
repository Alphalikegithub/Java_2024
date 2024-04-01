package com.cskaoyan.javase._2singleton.hungryMode;

import com.cskaoyan.javase._2singleton.lazyMode.Singleton1;
import com.cskaoyan.javase._2singleton.hungryMode.Singleton4;
import org.junit.Test;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-18 21:21
 **/

public class SingletonTest1 {
    @Test
    public void myTest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton4 instance1 = Singleton4.getInstance();
                System.out.println(instance1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton4 instance2 = Singleton4.getInstance();
                System.out.println(instance2);
            }
        }).start();
    }

    @Test
    public void myTest1() {
        Singleton5 instance1 = Singleton5.getInstance();
        Singleton5 instance2 = Singleton5.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
    @Test
    public void myTest2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton5 instance1 = Singleton5.getInstance();
                System.out.println(instance1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton5 instance2 = Singleton5.getInstance();
                System.out.println(instance2);
            }
        }).start();
    }
}
