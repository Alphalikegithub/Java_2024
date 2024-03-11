package com.cskaoyan.io2._02nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: Java_2024
 * @description: Nio文件流
 * @create: 2024-03-08 16:48
 **/

public class NioTest {
    @Test
    public void myTest1() {
        //创建1个字节缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println("buffer = " + buffer);
    }

    //读取数据
    @Test
    public void myTest2() {
        //创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer);
        //put方法放入数据
        buffer.put("abcd".getBytes());
        System.out.println(buffer);
        //从缓冲区中取数据get
        //反转操作 读取模式切换
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }

    /*内存映射*/
    @Test
    public void myTest3() throws IOException {
        //获取文件通道
        FileChannel fileChannel = new RandomAccessFile("a.txt", "rw").getChannel();
        //进行映射
        MappedByteBuffer mappedByteBuffer =
                fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());
        mappedByteBuffer.put(0, ((byte) 'b'));
        System.out.println(mappedByteBuffer);
    }

    @Test
    public void myTest4() throws IOException {
        //获取文件通道
        FileChannel fileChannel = new RandomAccessFile("a.txt", "rw").getChannel();
        //进行映射
        MappedByteBuffer mappedByteBuffer =
                fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());
        byte b = mappedByteBuffer.get();
        System.out.println(b);
    }

    /*    实现零拷贝复制文件*/
//    public abstract long transferFrom(     java.nio.channels.ReadableByteChannel src,
//                                           long position,
//                                           long count )
    @Test
    public void myTest5() throws IOException {
        FileChannel outChannel = new FileOutputStream("copy_channel_a.txt").getChannel();
        FileChannel inChannel = new FileInputStream("a.txt").getChannel();
        outChannel.transferFrom(inChannel,0,inChannel.size());//复制
    }

    /*使用工具实现文件复制*/
    @Test
    public void myTest6() throws IOException{
        ///FileUtils
    }
}
