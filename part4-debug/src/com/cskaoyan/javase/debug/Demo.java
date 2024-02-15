package com.cskaoyan.javase.debug;

import java.util.Scanner;

/**
 * @program: Java_2024
 * @description: IDEA的Debug模式
 * @create: 2024-01-13 08:15
 **/

public class Demo {
    public static void main(String[] args) {
        System.out.println("hello,world");
        boolean flag = true;
        /*while (flag) {

            System.out.println("是否继续？（1/N）");
            String str = sc.next();
            if (str.equals("1")) {
                flag = true;
            } else {
                flag = false;
            }
        }*/
        int a = 10;
        int b = 20;
        int c;
        c = a + b;
        System.out.println("请输入一个整形类型数字");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num > 0) {
            System.out.println("你输入的数字大于0");
        } else if (num == 0) {
            System.out.println("你输入的数字等于0");
        } else {
            System.out.println("你输入的数字小于0");
        }
//        5行3列
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        new A().test().test2();
    }
}

class A {
    public A() {
        System.out.println("nihao");
    }

    public A test() {
        System.out.println("nnnnnnnn");
        return  new A();
    }
    public  void test2(){
        System.out.println("你怎么睡得着的");
    }
}
