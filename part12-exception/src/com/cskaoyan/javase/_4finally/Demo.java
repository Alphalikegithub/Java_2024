package com.cskaoyan.javase._4finally;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-02-29 23:58
 **/

public class Demo {
    public static void main(String[] args) {
        try {
            System.out.println("before");
            System.out.println(10 / 0);
            System.out.println("after");
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("捕获到了异常");
            //return;
        }finally {
            //一定会执行
            System.out.println("finally执行了");
        }
    }

}
