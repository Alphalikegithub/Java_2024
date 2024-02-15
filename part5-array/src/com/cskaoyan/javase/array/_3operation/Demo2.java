package com.cskaoyan.javase.array._3operation;

import java.util.Arrays;

/**
 * @program: Java_2024
 * @description: 杨辉三角
 * @create: 2024-01-15 11:56
 **/

public class Demo2 {
    public static void main(String[] args) {
        printYangHui(5);
    }

    public static void printYangHui(int n) {
        //打印杨辉三角
        //1.创建二维数组
        int[][] yangHuiArray = new int[n][];
        for (int i = 0; i < yangHuiArray.length; i++) {
            //一维数组使用动态初始化
            yangHuiArray[i] = new int[i + 1];
        }
        System.out.println(Arrays.deepToString(yangHuiArray));
        //元素赋值
        /*1.前两行元素都是1
         * 2.从第3行开始，首位元素也是1，其他中间元素是同列上一行元素+左边一列上一行元素*/
        //遍历二维数组
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < i + 1; j++) {
                yangHuiArray[i][j] = 1;
            }
        }
        System.out.println(Arrays.deepToString(yangHuiArray));

        //从第3行开始，首位元素也是1，其他中间元素是同列上一行元素+左边一列上一行元素
        for (int i = 2; i < yangHuiArray.length; i++) {
            //首位元素赋值为1
            yangHuiArray[i][0] = 1;
            yangHuiArray[i][yangHuiArray[i].length - 1] = 1;
            yangHuiArray[i][i] = 1;
        }
        System.out.println(Arrays.deepToString(yangHuiArray));
    }
}

