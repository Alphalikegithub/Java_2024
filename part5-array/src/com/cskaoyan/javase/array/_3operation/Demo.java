package com.cskaoyan.javase.array._3operation;

import java.util.Arrays;

/**
 * @program: Java_2024
 * @description: 数组的遍历
 * @create: 2024-01-13 11:04
 **/
//遍历一维数组的方法 Arrays.toString(数组)
//该方法是有返回值的，返回一个字符串来表示数组

//    增强for循环的方法
//    for(数据类型 变量名 : 要遍历的集合或数组){}


public class Demo {
    public static void main(String[] args) {
        String[] arr = {"张三", "李四", "王麻子"};
        String str = Arrays.toString(arr);
        System.out.println(str);
        double[] arr2 = {0.1, 0.2, 0.3};
        for (double element : arr2) {
            //element已经是数组中的元素了，不需要在考虑arr2[element]下标之类的东西
            System.out.println(element);
        }
        int[] arr3 = {34, 45, 89, 789, 445};

        System.out.println(getMaxValue(arr3));

        System.out.println(Arrays.toString(arr3));
        reverse(arr3);
        System.out.println(Arrays.toString(arr3));

        System.out.println(getIndexRetrieveTargetElement(arr3,33));

        doubleParameter(arr3);
        System.out.println(Arrays.toString(arr3));

        // 调用
        print(new String[]{"Hello"});
        /*print("Hello", "World");
        print("Hello", "World", "!");*/
    }

    //求int[]类型数组中的最大值
    public static int getMaxValue(int[] arr) {
        //1.假设第一个元素是最大值
        int max = arr[0];
        //2.可以从第二个元素开始遍历比较
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //数组的逆置
    public static void reverse(int[] arr) {
        //逆序是一个交换元素的过程
        /*
        arr[0] <---> arr[arr.length -1]
        arr[1] <---> arr[arr.length -2]
        arr[2] <---> arr[arr.length -3]
        */
        //交换到中间需要停止交换，否则又会回到逆序之前的状态
        for (int i = 0; i < arr.length / 2; i++) {
            //交换变量的值
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    //数组中元素的检索，找到一个元素后，返回他的下标值
    public static int getIndexRetrieveTargetElement(int[] arr, int target) {
        //遍历数组
        //预先定义一个int变量，用来存储可能查找到的target值下标
        int targetIndex = -1;//不合法的标识
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target)
            {
                targetIndex = i;
            }
        }
        return  targetIndex;
    }

    //Java中的引用传递和值传递
    public  static  void doubleParameter(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 989894455;
        }

    }

    /*// 可变参数
    public static void print(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }*/

    // 不可变参数
    public static void print(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }



}
