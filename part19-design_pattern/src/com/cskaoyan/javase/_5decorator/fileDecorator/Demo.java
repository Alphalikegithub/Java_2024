package com.cskaoyan.javase._5decorator.fileDecorator;

import java.io.*;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-19 08:42
 **/
/*利用装饰器设计模式思想,以及BufferedInputStream,设计一个类LowerCaseInputStream 我们去装饰BufferedInputStream,实现如下功能:

扩展其功能,将读取到的英文字符大写的全部转化为小写的,比如a.txt文件中的内容为ABC,那么我们使用LowerCaseInputStream 读取到的数据打印出来的应该是abc.

提示:
重写read方法*/
public class Demo {
    public static void main(String[] args) throws IOException {
        //创建输入流对象
        LowerCaseInputStream lowerCaseInputStream =
                new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("D:\\Java\\IdeaProjects\\Java_2024\\part19-design_pattern\\a.txt")));
        //read
        /*int readData1 = lowerCaseInputStream.read();
        int readData2 = lowerCaseInputStream.read();
        int readData3 = lowerCaseInputStream.read();
        System.out.println((char) readData1);
        System.out.println((char) readData2);
        System.out.println((char) readData3);
        //close
        lowerCaseInputStream.close();*/

        byte[] bytes = new byte[1024];
        int readCount = lowerCaseInputStream.read(bytes, 0, bytes.length);
        System.out.println(new String(bytes, 0, readCount));
        //close
        lowerCaseInputStream.close();
    }
}
class LowerCaseInputStream extends FilterInputStream{

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }
    //重写read方法

    @Override
    public int read() throws IOException {
        //把大写转为小写
        int readData = super.read();
        return readData == -1 ? readData: ((int) Character.toLowerCase((char) readData));
    }
    //重写read方法read(byte[] b, int off, int len)
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int readCount = super.read(b, off, len);
        //遍历数组 大写转小写
        for (int i = off; i < off+len ; i++) {
            b[i] = ((byte) Character.toLowerCase((char) b[i]));

        }
        return readCount;
    }
}
