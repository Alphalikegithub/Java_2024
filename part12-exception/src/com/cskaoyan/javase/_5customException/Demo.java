package com.cskaoyan.javase._5customException;

import java.util.Scanner;

/**
 * @program: Java_2024
 * @description:考试成绩必须在0-100分之间，如果有考试成绩不在该范围内，则认为成绩异常
 * @create: 2024-03-02 17:01
 **/

public class Demo {
    public static void main(String[] args) {
        try {
            func();
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }

    private static void func() throws MyException {
        //用户输入一个分数，判断该分数是否在0-100范围内
        System.out.println("请输入一个分数");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i < 0 || i > 100) {
            //throw new MyException2("分数不合法");
            throw new MyException("分数不合法");
        }

    }
}

//定义一个编译时异常
class MyException extends Exception {
    //两个构造方法
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}

//定义一个运行时异常
class MyException2 extends RuntimeException {
    public MyException2() {
    }

    public MyException2(String message) {
        super(message);
    }
}