package com.cskaoyan._3API;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-11 21:57
 **/

public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("main before");
        MyThread4 myThread4 = new MyThread4();
        myThread4.start();
        try {
            //join的功能：“插队”
            //哪个线程调用了join() 哪个线程就等待
            myThread4.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main after");
    }
}
class MyThread4 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                //当前线程暂停执行
                //作用和TimeUnit.SECONDS.sleep(1);一样
                //Thread.yield();
                Thread.sleep(1000);
//                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
