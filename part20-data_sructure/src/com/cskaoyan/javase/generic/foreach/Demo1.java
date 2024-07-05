package com.cskaoyan.javase.generic.foreach;

/**
 * @author alpha
 * @program: Java_2024
 * @description: foreach循环
 * @since 2024-07-05 10:35
 **/

public class Demo1 {
    public static void main(String[] args) {
        // 创建一个大小为10的字符串数组
        String[] strings = new String[10];

        // 添加10个元素
        strings[0] = "Element 1";
        strings[1] = "Element 2";
        strings[2] = "Element 3";
        strings[3] = "Element 4";
        strings[4] = "Element 5";
        strings[5] = "Element 6";
        strings[6] = "Element 7";
        strings[7] = "Element 8";
        strings[8] = "Element 9";
        strings[9] = "Element 10";

        // 使用普通for循环遍历数组并打印每个元素
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
        }

        System.out.println(); // 换行

        // 使用foreach循环遍历数组并打印每个元素
        for(String str : strings){
            System.out.println(str);
        }
    }
}
