package com.cskaoyan._1imlpone;

/**
 * @program: Java_2024
 * @description: 创建线程的实现方式1
 * @create: 2024-03-11 15:25
 **/
/*1.继承Thread类
2.重写run方法
3.创建子类对象
4.启动线程start()*/
public class Demo {
    public static void main(String[] args) {
        System.out.println("main before");
        //3.创建子类对象
        MyThread myThread = new MyThread();
        //4.启动线程start()
        myThread.start();

        /*另外一个线程*/
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        System.out.println("main after");
    }
}
//1.继承Thread类
class MyThread extends Thread{
    //2.重写run方法

    @Override
    public void run() {
        super.run();
        //把想要在线程里面做的事情放在run()方法里
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

//1.继承Thread类
class MyThread2 extends Thread{
    //2.重写run方法

    @Override
    public void run() {
        super.run();
        //把想要在线程里面做的事情放在run()方法里
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
//给线程分配CPU处理权的一个过程   协同实现
//CPU时间片轮转算法
