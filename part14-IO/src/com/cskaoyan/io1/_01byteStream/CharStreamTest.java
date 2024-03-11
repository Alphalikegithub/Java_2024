package com.cskaoyan.io1._01byteStream;

import org.junit.Test;

import java.io.*;

/**
 * @program: Java_2024
 * @description: 字符流
 * @create: 2024-03-07 16:53
 **/
public class CharStreamTest {
    @Test
    public void myTest() throws IOException {
        //创建输出流对象
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("a.txt"));
        //write写数据
        char[] chars= {'你','好'};
        out.write(chars);
        out.flush();
        out.close();
    }

    @Test
    public void myTest2() throws IOException {
        InputStreamReader in = new InputStreamReader(new FileInputStream("a.txt"));
        read1(in);

        read2(in);

    }
    private static void read1(InputStreamReader in) throws IOException {
        //read() 读取单个字符
        int readData = in.read();
        System.out.println((char) readData);
    }

    private static void read2(InputStreamReader in) throws IOException {
        //read(char[] c)
        char[] chars = new char[1024];

        //返回值是读取的字符的个数
        int readCount  = in.read(chars);
        String s = new String(chars, 0, readCount);
        System.out.println(s);
    }

    @Test
    public void myTest3() throws IOException{
        //简化的输出流
        FileWriter fileWriter = new FileWriter("a.txt");
        //write数据
        fileWriter.write("年轻人不讲武德");
        fileWriter.flush();
        fileWriter.close();
    }

    @Test
    public void myTest4() throws IOException{
        //简化的输入流
        FileReader fileReader = new FileReader("yyds.txt");
        char[] chars = new char[1024];
        int readCount = fileReader.read(chars);
        String s = new String(chars, 0, readCount);
        System.out.println(s);
        //close
        fileReader.close();
    }
    //字符缓冲输出流
    @Test
    public void myTest5() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("a.txt"));
        bufferedWriter.write("我变强了");
        //自己独有的方法 newLine()
        bufferedWriter.newLine();
        bufferedWriter.write("也变秃了");
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}
