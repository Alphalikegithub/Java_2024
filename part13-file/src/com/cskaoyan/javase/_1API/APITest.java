package com.cskaoyan.javase._1API;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-04 17:11
 **/

public class APITest {
    @Test
    public void myTest1(){
        System.out.println("hello world!");
        //查看相对路径
        String property = System.getProperty("user.dir");
        System.out.println(property);
        //File类的构造方法
        //File file = new File("D:\\app2\\a.jpg");
        File file = new File("D:\\Java\\IdeaProjects\\Java_2024");
        boolean exists = file.exists();
        System.out.println(exists);
        File file1 = new File("a.txt");
        boolean exists1 = file1.exists();
        System.out.println(exists1);
    }
    @Test
    public void myTest2() throws IOException {
        //创建目录
        //1.只负责创建文件，目录路径如果不存在，会报错而不是帮你创建
        //public boolean createNewFile()
        File file = new File("b.txt");
        System.out.println("file.createNewFile() = " + file.createNewFile());
        //2.负责创建目录，但只能创建单层目录，如果有多级目录不存在的话，创建失败
        File dir = new File("a\\b\\c");
        System.out.println("dir.mkdir() = " + dir.mkdir());
        //3.负责创建目录，但只能创建多级目录，如果有多级目录不存在的话，则帮你全部创建
        File dirs = new File("test");
        System.out.println("dirs.mkdirs() = " + dirs.mkdirs());
    }

    @Test
    public void myTest3(){
        //文件重命名
        File file = new File("test\\b.txt");
        boolean b = file.renameTo(new File("c.txt"));
        System.out.println("b = " + b);
    }

    @Test
    public void myTest4(){
        //删除功能
        File dir = new File("test");
        System.out.println("dir.delete() = " + dir.delete());
        File deleteDir = new File("deleteDir");
        System.out.println("deleteDir.mkdir() = " + deleteDir.mkdir());
        System.out.println("deleteDir.delete() = " + deleteDir.delete());

    }
}
