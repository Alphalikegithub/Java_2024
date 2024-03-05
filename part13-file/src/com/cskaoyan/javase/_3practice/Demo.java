package com.cskaoyan.javase._3practice;

import java.io.File;

/**
 * @program: Java_2024
 * @description: 递归输出某个目录下的所有java 文件
 * @create: 2024-03-04 21:25
 **/

public class Demo {
    public static void main(String[] args) {
        File dir1 = new File("D:\\Java\\IdeaProjects\\Java_2024\\part13-file");
        findAllJavaFile(dir1);

    }

    private static void findAllJavaFile(File dir) {
        //1.把该目录下的所有内容都列出来
        File[] files = dir.listFiles();
        for(File f : files){
            //2.判断是否为文件
            if(f.isFile()){
                //3.如果是文件 再去判读是否为java文件、
                if(f.getName().endsWith(".java")){
                    //如果是java文件，输出绝对路径
                    System.out.println("f.getAbsoluteFile() = " + f.getAbsoluteFile());
                }
            }else{
                //不是文件 是目录
                //递归调用
                findAllJavaFile(f);
            }
        }

    }
}
