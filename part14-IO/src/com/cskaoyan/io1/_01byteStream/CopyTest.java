package com.cskaoyan.io1._01byteStream;

import org.junit.Test;

import java.io.*;

/**
 * @program: Java_2024
 * @description: 文件复制功能
 * @create: 2024-03-05 23:48
 **/

public class CopyTest {
    @Test
    public void myTest1() throws IOException {
        //创建输入流对象
        FileInputStream inputStream = new FileInputStream("haokan.png");
        //创建输出流对象
        FileOutputStream outputStream = new FileOutputStream("copy_haokan.png");
        //边读边写
        long start = System.currentTimeMillis();
        copy1(inputStream, outputStream);
        //copy2(inputStream, outputStream);
        //循环结束，复制完成
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //close
        inputStream.close();
        outputStream.close();
    }

    private static void copy2(FileInputStream inputStream, FileOutputStream outputStream) throws IOException {
        //多字节复制
        int readCount;
        byte[] bytes = new byte[1024];
        while ((readCount = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, readCount);
        }
    }

    private static void copy1(FileInputStream inputStream, FileOutputStream outputStream) throws IOException {
        //单字节
        int readData;
        while ((readData = inputStream.read()) != -1) {
            outputStream.write(readData);
        }
    }

    //使用缓冲流实现文件复制
    @Test
    public void myTest2() throws IOException {

        BufferedInputStream bi = new BufferedInputStream(new FileInputStream("haokan.png"));
        //创建缓冲的输出流对象
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("copy2_haokan.png"));
        //边读边写
        long start = System.currentTimeMillis();
        //单字节的方式去复制 454ms
        //copy3(bi, bo);
        //用多字节的方式复制 59ms
        copy4(bi, bo);
        long end = System.currentTimeMillis();
        System.out.println((end - start));
        bo.flush();
        bo.close();
        bi.close();
    }

    private static void copy4(BufferedInputStream bi, BufferedOutputStream bo) throws IOException {
        int readCount;
        byte[] bytes = new byte[1024];
        while ((readCount = bi.read(bytes)) != -1){
            bo.write(bytes,0,readCount);
        }
    }

    private static void copy3(BufferedInputStream bi, BufferedOutputStream bo) throws IOException {
        int readData;
        while ((readData = bi.read()) != -1) {
            bo.write(readData);
        }
    }
}
