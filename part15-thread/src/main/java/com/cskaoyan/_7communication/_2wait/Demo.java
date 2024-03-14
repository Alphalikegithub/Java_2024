package com.cskaoyan._7communication._2wait;

/**
 * wait方法的特点/作用:
 * 用一个锁对象(在同步代码块/同步方法)中,来调用wait方法
 * 会使得此线程立刻释放锁,并处于无限等待阻塞状态,直到用同一把锁对象来调用notify方法来通知唤醒此线程!
 *
 * wait方法的使用:
 *      1.使用的条件,必须在同步代码块/同步方法中,用锁对象调用此方法.
 *      2.(重点)执行的特点
 *          a.会立刻让此线程处理无限等待阻塞状态,需要用同一把锁对象来调用notify方法才会结束阻塞
 *          b.(重点)立刻释放锁
 *
 * @since 14:45
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    private final static Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println("wait before");
                    // 在此锁对象上调用wait,A线程进入等待状态
                    LOCK.wait();
                    System.out.println("wait after");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        // 主线程休眠1s,保证wait线程（A线程）优先启动
        Thread.sleep(1000);
        new Thread(() -> {
            synchronized (LOCK) {
                System.out.println("B线程获取了锁对象并执行!");
            }
        }, "B").start();

        /*Object o = new Object();
        synchronized (o) {
            try {
                System.out.println("wait before");
                // 在锁对象上调用wait
                o.wait();
                System.out.println("wait after");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
