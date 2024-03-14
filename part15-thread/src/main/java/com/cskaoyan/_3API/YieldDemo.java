package com.cskaoyan._3API;

/**
 * @program: Java_2024
 * @description: 将 CPU 时间片让给其他线程
 * @create: 2024-03-11 23:26
 **/

public class YieldDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程 1：" + i);
                if (i == 5) {
                    Thread.yield();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程 2：" + i);
            }
        });

        thread1.start();
        thread2.start();
    }
}

