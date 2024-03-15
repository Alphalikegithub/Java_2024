package com.cskaoyan._5lock._0introduction;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Java_2024
 * @description:lock锁
 * @create: 2024-03-14 08:18
 **/

public class Demo2 {
    public static void main(String[] args) {
        SellTicketTask sellTicketTask = new SellTicketTask();
        new Thread(sellTicketTask,"窗口Ⅰ").start();
        new Thread(sellTicketTask,"窗口Ⅱ").start();
        new Thread(sellTicketTask,"窗口Ⅲ").start();


    }
}

class SellTicketTask implements Runnable {
    int ticketNum = 1;
    //定义一把锁
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try{
                if (ticketNum <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + "卖了" + ticketNum + "张票！");
                    ticketNum++;
                } else {
                    System.out.println("票已经卖完了 ，下次再来吧");
                    break;
                }
            }finally {
                //保证一定释放锁
                lock.unlock();
            }

        }
    }
}