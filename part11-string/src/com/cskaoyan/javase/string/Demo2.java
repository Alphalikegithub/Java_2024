package com.cskaoyan.javase.string;

/**
 * @program: Java_2024
 * @description: 啊
 * @create: 2024-02-29 00:04
 **/

public class Demo2 {
    public static void main(String[] args) {
        String s = "i want a big ice cream";

        String[] s1 = s.split(" ");
        //定义一个空字符串
        String newStr = "";
        for (String str : s1) {
            //取出字符串的第一个字符 变大写
            String concat = str.substring(0, 1).toUpperCase().concat(str.substring(1));
            newStr += concat + " ";
        }
        System.out.println(newStr.trim());

    }
}
