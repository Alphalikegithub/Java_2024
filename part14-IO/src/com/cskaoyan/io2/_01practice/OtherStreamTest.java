package com.cskaoyan.io2._01practice;

import org.junit.Test;

import java.io.*;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-07 21:22
 **/

public class OtherStreamTest {
    @Test
    public void myTest() throws IOException {
        //创建输出流对象
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("a.txt"));
        dataOutputStream.writeInt(1000);
        dataOutputStream.close();
        //写入数据的类型要和读取数据的类型的 顺序保持一致
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("a.txt"));
        byte[] bytes = new byte[1024];
        int i = dataInputStream.readInt();
        System.out.println(i);
        dataInputStream.close();
    }

    /*字符打印流的自动刷新*/
    @Test
    public void myTest1() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("a.txt"));
        writer.println(1000);
        writer.flush();
    }

    @Test
    public void myTest3(){
        PrintWriter writer = new PrintWriter(System.out);
        writer.print(1000);
        writer.flush();
    }
}
