package com.cskaoyan._7communication._3notify;

/**
 * notify()方法
 * 执行wait()方法而进入等待状态的线程，必须被其它线程用同一个锁对象调用notify()方法才能够被唤醒。
 * 可以做以下理解:
 * 某个锁对象调用wait方法使得某个线程进行无限等待阻塞状态,可以认为此线程在这个锁对象上处于阻塞状态
 * 那么要想唤醒它,就必须用同一把锁对象调用notify方法来唤醒这把锁处于等待阻塞状态的线程
 * 注意:
 * 如果锁对象上有多个线程处于等待阻塞状态，则唤醒其中随机一个线程并使该线程重新获取锁。
 * 当然如果锁对象上就只有一个线程等待,那就直接唤醒它
 *
 * notify方法的执行特点:
 * 立刻随机唤醒此锁对象上处于等待阻塞状态的一个线程
 * 和wait方法执行后立刻释放锁不同,notify方法的执行不会释放锁,而还是等到执行完毕同步区域再释放锁
 *
 * 等待唤醒机制的描述:
 *      1.A线程调用wait方法阻塞自己,立刻释放锁,等待同一把锁调用notify方法来唤醒它
 *      2.B线程获取锁后,调用notify方法就会唤醒此时锁上处于等待状态的A线程,但是不会立刻释放锁,而是等到同步区域执行完毕才会释放锁
 *      3.B同步区域执行完毕释放锁,A线程就获取了锁,A就继续执行wait之后的代码,而不是重头执行!!
 *
 * @since 14:53
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    private static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("A启动了!但是没有获取锁!");
            synchronized (o) {
                System.out.println("A线程获取了锁对象!");
                try {
                    System.out.println("A wait before");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    o.wait();
                    System.out.println("A wait after");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A线程执行完毕了!");
            }
        }, "A").start();
        Thread.sleep(1000);

        new Thread(() -> {
            System.out.println("B启动了!但是没有获取锁!");
            synchronized (o) {
                System.out.println("B线程获取了锁对象!");
                System.out.println("notify before");
                o.notify();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("notify after");
                System.out.println("B线程执行完毕了!");
            }
        }, "B").start();
    }

}

