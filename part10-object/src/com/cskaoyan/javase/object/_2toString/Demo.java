package com.cskaoyan.javase.object._2toString;

/**
 * @program: Java_2024
 * @description: toString()方法
 * @create: 2024-01-31 22:29
 **/

public class Demo {
    public static void main(String[] args) {
        String a = "456";
        int i  = 10;//Hash方法
        System.out.println(a);
        System.out.println(i);
        //将对象的地址转换成一个十进制数
        Student student = new Student(15,89);
        Class stuClazz = student.getClass();
        System.out.println(stuClazz.getSimpleName());
        System.out.println(student);
        System.out.println(student + "hello world".toString());
        System.out.println(student.toString());
    }
}

class Student{
    int age;
    double score;

    public Student(int age, double score) {
        this.age = age;
        this.score = score;
    }
}
