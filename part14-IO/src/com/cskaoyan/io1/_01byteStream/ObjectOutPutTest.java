package com.cskaoyan.io1._01byteStream;

import java.io.*;

/**
 * @program: Java_2024
 * @description: ObjectOutPutStream将Java对象的基本数据类型和图像写入ObjectInputStream
 * @create: 2024-03-08 08:52
 **/

public class ObjectOutPutTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //只能将支持java.io.Serializable接口的对象写入流中
        Student stu = new Student("zhangsan", 20);
        //创建序列化流对象
        ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("stu.txt"));

        //写对象
        ob.writeObject(stu);
        ob.close();
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("stu.txt"));
        Object o = oi.readObject();
        System.out.println(o);
    }
}
//创建一个学生对象，被这个学生对象相关属性保存到一个文件当中
//标记接口Serializable
class Student implements Serializable {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "String{" +
                "name='" + name +'\'' +
                ",age="  + age +
                '}';
    }
}