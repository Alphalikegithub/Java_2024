package com.cskaoyan.javase.string;

import java.util.Scanner;

/**
 * @program: Java_2024
 * @description: 字符串反转
 * @create: 2024-02-27 23:53
 **/

public class stringInversion {
    public static void main(String[] args) {
        //键盘输入字符串
        while (true){
            System.out.println("请输入一串英文字符");
            Scanner scanner = new Scanner(System.in);
            //得到字符串
            String s = scanner.nextLine();
            //倒着遍历
            func2(s);
            //func1(s);
        }

    }

    private static void func2(String s) {
        char[] charArray = s.toCharArray();
        String str = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            str += charArray[i];
        }
        System.out.println(str);
    }

    private static void func1(String s) {
        String newStr = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            newStr += s.charAt(i);
        }
        System.out.println(newStr);
        //重新拼接
    }
}
