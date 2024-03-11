package com.cskaoyan.io1._01byteStream;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @program: Java_2024
 * @description: BufferedOutputStream
 * @create: 2024-03-06 16:06
 **/

public class BufferTset
{
    @Test
    public void myTest() throws IOException {
        //创建输出流对象  BufferedOutputStream是一个包装流，是建立在FileOutputStream流的基础上
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("a.txt"));
        //write
        //bo.write(97);
        bo.write("飞啊飞啊发 ".getBytes());
        //flush
        bo.flush();
        //close
        bo.close();
    }
    //Java当中的编解码
    @Test
    public void myTest1() throws UnsupportedEncodingException {
        //打印编码类型
        System.out.println(Charset.defaultCharset());
        //创建输入流对象
        String s = "编解码问题";
//        byte[] bytes = s.getBytes();
//        System.out.println(Arrays.toString(bytes));
        //默认字符是一个中文集合 GBK一个中文占2个字节 UTF-8一个中文占3个字节
        //使用指定的额字符集将String 编码为byte序列
        byte[] gbks = s.getBytes("GBK");
        System.out.println(Arrays.toString(gbks));
        //解码
        //将编码值还原为字符串的过程
//        public String(     @NotNull  byte[] bytes,@NonNls  @NotNull  String charsetName )
        String s1 = new String(gbks,"GBK");
        System.out.println(s1);
    }
}

