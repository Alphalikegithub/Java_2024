package com.cskaoyan.javase._1handle;

/**
 * @program: Java_2024
 * @description:try- catch 快捷键Ctrl + Alt + T
 * @create: 2024-02-29 23:09
 **/

public class Demo {
    public static void main(String[] args) {
        try {
            System.out.println("extracted() before");
            System.out.println(10 / 0);
            System.out.println("extracted() after");
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("捕获到了异常");
        }
        //编译时异常
        Demo demo = new Demo();
        try {
            demo.clone();
        } catch (CloneNotSupportedException e1) {
            e1.printStackTrace();
        }
    }
}
