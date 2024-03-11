package com.cskaoyan._1imlpone.wuyanzu;

import com.cskaoyan._1imlpone.wuyanzu.MyThread3;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-11 20:47
 **/

public class Demo {
    public static void main(String[] args) {
        MyThread3 myThread1 = new MyThread3();
        MyThread3 myThread2 = new MyThread3();
        //设置线程名称
        myThread1.setName("吴彦祖");
        myThread2.setName("彭于晏");
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