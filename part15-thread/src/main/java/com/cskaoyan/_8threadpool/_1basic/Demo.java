package com.cskaoyan._8threadpool._1basic;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Java_2024
 * @description: 线程池
 * @create: 2024-03-15 00:12
 **/

public class Demo {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //向线程池中提交任务//submit
        pool.submit(new MyTask());
        pool.submit(new MyTask());
        pool.submit(new MyTask());
        pool.submit(new MyTask());

//        pool.shutdown();//队列中等待的任务执行完后关闭
        pool.shutdownNow();//正在执行的任务结束后立即关闭
    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}
