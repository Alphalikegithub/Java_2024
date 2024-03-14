package com.cskaoyan._7communication._4exercise;

import java.util.concurrent.TimeUnit;

/**
 * 读程序题
 * @since 15:07
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    // 一把同步锁
    private static final Object OBJECT = new Object();
    public static void main(String[] args) {
        // 创建并启动一个线程
        new Thread(() -> {
            System.out.println("A线程已经执行！");
            // sync
            synchronized (OBJECT) {
                System.out.println("A线程执行sync！");
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("wait before");
                    // wait
                    OBJECT.wait();
                    System.out.println("wait after");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A over");
            }
        }, "A").start();
        // 主线程休眠3s
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 创建并启动一个线程
        new Thread(() -> {
            System.out.println("B线程已经执行！");
            // sync
            synchronized (OBJECT) {
                System.out.println("B线程执行sync！");
                System.out.println("notify before");
                OBJECT.notify();
                System.out.println("notify after");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B over");
            }
        }, "B").start();
    }
}
