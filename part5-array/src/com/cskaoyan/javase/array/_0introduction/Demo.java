package com.cskaoyan.javase.array._0introduction;

/**
 * @program: Java_2024
 * @description: 数组
 * @create: 2024-01-13 09:07
 * <p>
 * 数组初始化的两种方式：
 * 格式1：静态初始化
 * 语法：数据类型[] 数组名 = new 数据类型[] {元素1.元素2...}
 *
 *
 * 在String操作中为了避免空指针异常
 * 需要判断一个字符串是不是空的
 * String str1 = new String("123");
 * 可以写  str1.equals("");
 * 或者写  "".equals(str1);
 **/

public class Demo {
    public static void main(String[] args) {
        int[] arr = new int[]{};//长度为0的数组
        int[] arr2 = new int[]{1, 2, 4};
        int[] arr3 = new int[10];
        // 遍历数组 arr1
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // 遍历数组 arr2
        for (int j : arr2) {
            System.out.println(j);
        }
        // 遍历数组 arr3
        for (int k : arr3) {
            System.out.println(k);
        }
    }
}
