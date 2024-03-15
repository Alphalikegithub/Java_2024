package com.cskaoyan.javase._0introduction;


import java.net.URL;

/**
 * @program: Java_2024
 * @description: 类加载器
 * @create: 2024-03-15 15:55
 **/

public class Demo {
    public static void main(String[] args) {
        //获取类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //获取加载资源的路径
        URL resource = systemClassLoader.getResource("");
        System.out.println(resource);

        //获取扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        //获取根类加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }
}
