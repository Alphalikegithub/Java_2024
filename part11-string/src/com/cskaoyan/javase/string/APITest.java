package com.cskaoyan.javase.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: Java_2024
 * @description: 测试String的API函数
 * @create: 2024-02-26 23:15
 **/

public class APITest {

    @Test
    public void myTest1(){
        String s = "abc";
        //比较字符串内容
        //忽略字符串大小，比较字符串内容
        System.out.println();
        System.out.println("s.equalsIgnoreCase(\"ABC\") = " + s.equalsIgnoreCase("ABC"));
        //判断当前字符串对象是否包含目标字符串的字符序列
        System.out.println("s.contains(\"bc\") = " + s.contains("bc"));
        //判断当前字符串的对象，是否为目标字符串的字符序列开头
        System.out.println("s.startsWith(\"ab\") = " + s.startsWith("ab"));
    }
    @Test
    public void myTest2() {
        String s = "abcdef";
        // 获取当前字符串对象中，包含的字符个数
        //int length()
        System.out.println("s.length() = " + s.length());
        //获取字符串对象代表字符序列中，指定位置的字符
        //char charAt(int index)
        System.out.println("s.charAt(0) = " + s.charAt(0));

        //在当前字符串对象中查找指定的字符，如果找到就返回字符，首次出现的位置，如果没找到返回-1
        //也可以填字符
        //int indexOf(int ch)
        System.out.println("s.indexOf('g') = " + s.indexOf('g'));

        //指定从当前字符串对象的指定位置开始，查找首次出现的指定字符的位置，(如果没找到返回-1)
        //可以填入字符
        //int indexOf(int ch,int fromIndex)
        System.out.println("s.indexOf('d', 2) = " + s.indexOf('d', 2));

        //查找当前字符串中，目标字符串首次出现的位置(如果包含)，找不到，返回-1
        //这里的位置是指目标字符串的第一个字符,在当前字符串对象中的位置
        //int indexOf(String str)
        System.out.println("s.indexOf(\"ef\") = " + s.indexOf("ef"));

        //指定，从当前字符串对象的指定位置开始,查找首次出现的指定字符串的位置(如果没找到返回-1)
        //这里的位置是指目标字符串的第一个字符,在当前字符串对象中的位置
        //int indexOf(String str,int fromIndex) ，
        System.out.println("s.indexOf(\"ef\", 2) = " + s.indexOf("ef", 2));

        //返回字符串，该字符串只包含当前字符串中，从指定位置开始(包含指定位置字符)到结束的那部分字符串
        //String substring(int start)
        System.out.println("s.substring(1) = " + s.substring(1));

        //返回字符串，只包含当前字符串中，从start位置开始(包含)，到end(不包含)指定的位置的字符串
        //String substring(int start,int end)  区间[start, end)
        System.out.println("s.substring(0, 3) = " + s.substring(0, 3));

    }
    @Test
    public void myTest3() {
        String s = "abc";
        // 获取一个用来表示字符串对象字符序列的，字节数组
        //byte[] getBytes()
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));

        //获取的是用来表示字符串对象字符序列的，字符数组
        //char[] toCharArray()
        char[] chars = s.toCharArray();
        System.out.println(Arrays.toString(chars));


        //把字符数组转换成字符串
        //static String valueOf(char[] chs)
        char[] chars1 = {'h','e','l','l','o'};
        String s1 = String.valueOf(chars1);
        System.out.println(s1);

        //把各种基本数据类型和对象转换成字符串   1 →  "1"
        //static String valueOf(int i/double...)
        String s2 = String.valueOf(100);
        System.out.println(s2);
        String s3 = String.valueOf(3.14);
        System.out.println("s3 = " + s3);
        String s4 = String.valueOf(true);
        System.out.println("s4 = " + s4);


        //把字符串全部转化为小写
        //String toLowerCase()
        String s5 = "ABCD";
        String s6 = s5.toLowerCase();
        System.out.println("s6 = " + s6);

        //把字符串全部转换为大写
        //String toUpperCase()
        System.out.println("s.toUpperCase() = " + s.toUpperCase());
        //字符串拼接，作用等价于 + 实现的字符串拼接
        //String concat(String str)
        String s7 = "abc".concat("defgh");
        System.out.println("s7 = " + s7);
    }

}
