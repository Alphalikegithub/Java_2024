package com.cskaoyan.io2._01practice;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-08 09:47
 **/

public class RandomAccessFileTest {
    @Test
    public void myTest() throws IOException {
        //创建从中读取和向其中写入（可选）的随机访问文件流，该文件由File参数指定
        RandomAccessFile raf = new RandomAccessFile(new File("a.txt"), "rw");
        raf.write("absde".getBytes());
        raf.close();
    }

    @Test
    public void myTest2() throws IOException {
        //查看文件指针
        RandomAccessFile r = new RandomAccessFile(new File("a.txt"), "rw");
        //获取文件指针的当前位置
        System.out.println("r.getFilePointer() = " + r.getFilePointer());
        //移动指针
        r.seek(3);
        System.out.println("r.getFilePointer() = " + r.getFilePointer());
        r.write("insert".getBytes());
        System.out.println("r.getFilePointer() = " + r.getFilePointer());
        r.close();
    }
}

