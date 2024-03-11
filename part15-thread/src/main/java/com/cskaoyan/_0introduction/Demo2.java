package com.cskaoyan._0introduction;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @program: Java_2024
 * @description: 引入线程
 * @create: 2024-03-11 10:07
 **/
/*
* 进程是操作系统进行资源分配的基本单位
* 线程是CPU进行资源调度与分配的基本单位
*
* 串行：多个任务按顺序执行
* 并行：多个任务在同一个时间点上一起执行
* 并发：在同一个时间段内，多个任务同时执行
* */
public class Demo2 {
    public static boolean flag = true;
    public static void main(String[] args) {

        System.out.println("sayHello Before");
        sayHello();
        System.out.println("sayHello After");

        System.out.println("wait Before");
        waitToStop();
        System.out.println("wait After");
    }

    private static void waitToStop() {
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);

            while (flag) {
                String s = scanner.nextLine();
                if ("gun".equals(s)) {
                    //修改flag值
                    flag = false;
                }
            }
        }).start();
    }

    private static void sayHello() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag){
                    System.out.println("Hello world!");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();


    }
}
