package com.cskaoyan.io1._01byteStream;

import org.junit.Test;

import java.awt.event.HierarchyBoundsAdapter;
import java.io.*;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-05 16:13
 **/

public class ByteStreamTest {
    //FileOutputStream 构造方法
    @Test
    public void myTest1() throws FileNotFoundException {
        /*public FileOutputStream(     @NotNull  java.io.File file )*/
        FileOutputStream fileOutputStream = new FileOutputStream(new File("a.txt"));
        /*public FileOutputStream(     @NotNull  String name )*/
        FileOutputStream fileOutputStream1 = new FileOutputStream("b.txt");
    }

    //write数据
    @Test
    public void myTest2() throws IOException {
        //创建输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("b.txt");
        //write写数据
        //1.public void write(     int b )
        fileOutputStream.write(97);//写单个字节
        //2.public void write(     @NotNull  byte[] b )
        String s = "abcd";
        byte[] bytes = s.getBytes();
        fileOutputStream.write(bytes);
        //close
        fileOutputStream.close();
    }

    @Test
    public void myTest3() throws IOException {
        //创建输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("b.txt", true);
        //写数据
        fileOutputStream.write("d".getBytes());
        //换行符"\r\n"
        fileOutputStream.write("\r\n".getBytes());
        fileOutputStream.write("efg".getBytes());
        fileOutputStream.write(System.lineSeparator().getBytes());
        fileOutputStream.write("hij".getBytes());
        fileOutputStream.close();
    }

    @Test
    public void myTest4() {
        //
        try (FileOutputStream out = new FileOutputStream("b.txt")) {
            //write
            out.write("今天有点冷，宝，你多穿点，别着凉了".getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        //diagram
        //新建文件输出流对象
        //FileOutputStream fileOutputStream = new FileOutputStream("aaa.txt", false);

    }
    /*字节输入流读取数据*/
    @Test
    public void myTest5 () throws IOException {
        FileInputStream inputStream = new FileInputStream("b.txt");
        //1.@Range(from = -1, to = 255) public int read()
//        int read1 = inputStream.read();
//        System.out.println((char) read1);
//        int read2 = inputStream.read();
//        System.out.println((char) read2);
//        int read3 = inputStream.read();
//        System.out.println((char) read3);
//        int read4 = inputStream.read();
//        System.out.println((char) read4);
        //2.read(byte[] b)表示读取多个数组 并填充到数组中
        /*返回值表示的是读取到的字节个数*/
        byte[] bytes = new byte[8];
        int readCount = inputStream.read(bytes);
        System.out.println(readCount);
        String s = new String(bytes);
        System.out.println(s);
        //3.
        //4.
    }

    @Test
    public void myTest6(){
        System.out.println((char) 97); // a
        System.out.println((char) 98); // b
        System.out.println((char) 99); // c
        System.out.println((char) 10); // 换行符（LF）
        System.out.println((char) 13); // 回车符（CR）
        System.out.println((char) 100); // d
    }
    @Test
    public void myTest7() throws IOException {
        //循环读取字节流
        FileInputStream fileInputStream = new FileInputStream("b.txt");

        //读取文件的高级方法
        //1.单字节读取
        /*int readData;
        while((readData = fileInputStream.read()) != -1){

        }*/

        //readWhile(fileInputStream);
        //2.多字节读取
        int readCount;
        byte[] bytes = new byte[1024];
        while((readCount = fileInputStream.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, readCount));
        }

    }

    private static void readWhile(FileInputStream fileInputStream) throws IOException {
        //读取文件的高级方法
        //1.单字节读取
        int readData;
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
        while((readData = inputStreamReader.read()) != -1){
            //正确打印b.txt中的内容（b.txt中可能是中文）
            System.out.print((char)readData);
        }
    }
}
