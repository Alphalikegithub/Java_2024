package com.cskaoyan.javase._4fileFilter;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * @program: Java_2024
 * @description: 文件过滤器
 * @create: 2024-03-04 21:54
 **/

public class Demo {
    public static void main(String[] args) {
        File dir = new File("D:\\Java\\IdeaProjects\\Java_2024\\part13-file\\src\\com\\cskaoyan\\javase\\_4fileFilter");
        File[] files = dir.listFiles(new MyFilter());
        System.out.println(Arrays.toString(files));

    }
}
//实现FileFilter接口
class MyFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        //过滤规则：只有.java文件才满足要求
        return pathname.getName().endsWith(".java");
    }
}
