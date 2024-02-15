package com.cskaoyan.javase.recursion._0introduction;

/**
 * @program: Java_2024
 * @description: 递归的引入
 * @create: 2024-01-15 15:58
 **/

public class Demo {
    public static  void main(String[] args)
    {
        System.out.println(sum(9999));
    }
    //求前n个数的和
    public static int sum(int num)
    {
        if(0 == num){
            return  0;
        }
        int i = num + sum(num - 1);
        System.out.println("sum(" + num + ") = " + i);
        return  i;
    }
}
