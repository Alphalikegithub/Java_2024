package com.cskaoyan._4implement2;

/**
 * @program: Java_2024
 * @description: 匿名内部类
 * @create: 2024-03-12 00:11
 **/

public class Demo2 {
    public static void main(String[] args) {
        //匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "----" );
                System.out.println("11111");
            }
        }).start();

        //2.用lambda表达式
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "----" + i);
            }
        }).start();
    }
}
