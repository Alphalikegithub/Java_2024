package com.cskaoyan._7threadCommunication._0introduction;

/**
 * @program: Java_2024
 * @description: 练习：2个线程交替打印数字
 * @create: 2024-03-14 10:09
 **/

public class testWait {
    public static final Object obj = new Object();

    public static void main(String[] args) {
        //创建并启动线程
        new Thread(() -> {
            //使用wait notify改进
            synchronized (obj) {
                for (int i = 1; i <= 100; i += 2) {
                    //唤醒另一个线程
                    obj.notify();
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                    //立刻阻塞自己
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                obj.notify();//目的是为了不让线程阻塞
            }
        }, "A").start();


        new Thread(() -> {
            synchronized (obj) {
                for (int i = 2; i <= 100; i += 2) {
                    //唤醒另一个线程
                    obj.notify();
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                    //立刻阻塞自己
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                obj.notify();//目的是为了不让线程阻塞

            }
        }, "B").start();
    }
}
