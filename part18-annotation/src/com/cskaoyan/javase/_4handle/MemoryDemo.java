package com.cskaoyan.javase._4handle;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-18 11:05
 **/

public class MemoryDemo {
    public static void main(String[] args) {
        long l = Runtime.getRuntime().totalMemory();
        System.out.println(l/1024/1024);
        long l1 = Runtime.getRuntime().maxMemory();
        System.out.println(l1/1024/1024);
    }
}
