package com.cskaoyan._6communication._4exercise;

/**
 * 创建2个线程，A线程和B线程。
 * A线程打印1，B线程打印2，A线程打印3，B线程打印4....
 * A和B两个线程轮流打印数字，直到打印到100为止。（也就是A线程打印奇数，B线程打印偶数）
 * 思路:
 *      1.A线程先启动,打印一个1,先notify唤醒对方,然后要wait自己,释放锁,让B线程获取锁然后执行
 *      2.B线程获取锁后,打印一个2,先notify唤醒对方,然后要wait自己,释放锁,让A线程获取锁然后执行
 *
 * @since 15:14
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        int num = 100;
        new Thread(() -> {
            synchronized (o) {
                for (int i = 1; i <= num; i += 2) {
                    System.out.println("A打印了 " + i);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
            System.out.println("A线程执行完了!");
        }, "A").start();
        Thread.sleep(1000);
        new Thread(() -> {
            synchronized (o) {
                for (int i = 2; i <= num; i += 2) {
                    System.out.println("B打印了 " + i);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("B线程执行完了!");
        }, "B").start();
    }
}
