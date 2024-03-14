package com.cskaoyan._1imlpone.wuyanzu;

import com.cskaoyan._1imlpone.wuyanzu.MyThread3;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-11 20:47
 **/

public class Demo {
    public static void main(String[] args) {
        //返回对当前正在执行的线程对象的引用
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        MyThread3 myThread1 = new MyThread3();
        MyThread3 myThread2 = new MyThread3();
        //设置线程名称
        myThread1.setName("吴彦祖");
        myThread2.setName("彭于晏");
        //设置优先级
        myThread1.setPriority(Thread.MAX_PRIORITY);
        myThread2.setPriority(Thread.MIN_PRIORITY);
        //启动线程
        myThread1.start();
        myThread2.start();
    }
}
class MyThread3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //获取线程名称
            System.out.println(getName() + "-----" + i);
        }
    }
}