package com.cskaoyan._4synchronized._0introduction;

/**
 * @program: Java_2024
 * @description: 方式二
 * 多线程实现方式二
 * *
 * * 为了解决多线程环境下的数据共享安全问题,所以要把"多线程下共享数据类型的访问,修改等变成一个要么全部执行,要么都不执行的原子操作"
 * * 这种原子操作就可以把多任务的执行从多线程的异步执行,变成同步执行
 * * 这样就解决了线程数据安全问题
 * *
 * * 多线程的异步特点，导致了多个线程在处理共享数据时会出现数据安全问题。让多个线程在访问共享数据时，同步执行，以解决数据安全问题，这就是“线程同步”。
 * *
 * * 实现线程同步，在Java中比较常见的做法就是synchronized关键字。
 * @create: 2024-03-13 23:40
 **/

public class Demo2 {
    public static void main(String[] args) {
        SellWindow2 sellWindow2 = new SellWindow2();
        //sellWindow2 代表一个任务，该任务要在线程上面执行
        Thread t1 = new Thread(sellWindow2);
        Thread t2 = new Thread(sellWindow2);
        Thread t3 = new Thread(sellWindow2);
        t1.setName("窗口A");
        t2.setName("窗口B");
        t3.setName("窗口C");

        t1.start();
        t2.start();
        t3.start();

    }
}

class SellWindow2 implements Runnable {
    static int tickets = 1;

    @Override
    public void run() {
        while (tickets <= 100) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "张票!");
            tickets++;
        }
    }
}
