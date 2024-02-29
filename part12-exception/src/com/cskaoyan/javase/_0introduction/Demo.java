package com.cskaoyan.javase._0introduction;

/**
 * @program: Java_2024
 * @description: 异常的引入
 * @create: 2024-02-29 22:16
 **/

public class Demo {
    public static void main(String[] args) {

        try{
            System.out.println("extracted() before");
            extracted();
            System.out.println("extracted() after");
        }catch (ArrayIndexOutOfBoundsException | NullPointerException e){
            //System.out.println("捕获到了该异常");
            String message = e.getMessage();
            System.out.println("message = " + message);

            System.out.println("e.toString() = " + e.toString());

            e.printStackTrace();
        }


    }

    private static void extracted() {
        System.out.println("before");
        String[] strs = {"aa"};
        System.out.println(strs[1]);
        System.out.println("after");
    }
}

