package com.cskaoyan._4synchronized._1exercise;



import java.util.concurrent.TimeUnit;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-14 00:30
 **/

public class Demo {
    public static void main(String[] args) {
        SellTicketTask sellWindow = new SellTicketTask();
        //sellWindow2 代表一个任务，该任务要在线程上面执行
        Thread t1 = new Thread(sellWindow);
        Thread t2 = new Thread(sellWindow);
        Thread t3 = new Thread(sellWindow);
        t1.setName("窗口A");
        t2.setName("窗口B");
        t3.setName("窗口C");

        t1.start();
        t2.start();
        t3.start();
    }
}

class SellTicketTask implements Runnable {
    static int tickets = 1;
    //定义一把锁
    private static final Object o = new Object();

    @Override
    public void run() {
        while (tickets <= 100) {
            //使用同步代码块
            synchronized (o) {
                if (tickets <= 100) {
                    try {
                        // 模拟售票需要一定时间,所以延迟一下
                        TimeUnit.MILLISECONDS.sleep(((long) (Math.random() * 50)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "张票!");
                    tickets++;
                } else {
                    System.out.println("已经卖完了,下次再来吧!");
                    return;
                }
            }
        }
    }
}