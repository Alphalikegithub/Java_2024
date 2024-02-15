package com.cskaoyan.javase.array._1exercise;

import java.util.Scanner;

/**
 * @program: Java_2024
 * @description: 一个长度为0的数组的经典用途
 * @create: 2024-01-13 10:34
 **/
//需求：一个方法可能给出1个结果，2个结果，也可能没有结果，怎样写这样一个方法
//    Java的返回值只能是一个变量，如果有多个结果要返回们可以返回一个 容器
public class Demo {
    public static void main(String[] args) {
        int[] result = getResult(100);

        System.out.println(result[0]);
        System.out.println(result[1]);
        traverse(result);

    }

    public static void traverse(int[] arr) {
        for (int i = 0; i < 9; i++) {
            System.out.println("hu");
        }
    }

    public static int[] getResult(int num) {
        //声明一个数组引用，具体的初始化在if()中进行
        int[] result;
        //根据num的不同取值，结果也不同
        if (num == 0) {
            //给出一个结果
            result = new int[]{1};
            return result;
        } else if (num > 0) {
            //给出两个结果
            result = new int[]{1, 2};
            return result;
        } else {
            result = new int[0];
            return result;

        }
    }
}
