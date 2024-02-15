package com.cskaoyan.javase.oop1._0introduction;

/**
 * @program: Java_2024
 * @description: 对象的定义
 * @create: 2024-01-15 17:16
 **/

public class Demo {
    public static void main(String[] args) {
        System.out.println("这是一个类的声明");
        //创建对象
        Student student = new Student();
        System.out.println(student.name);
        System.out.println(student.age);
        System.out.println(student.sex);
        System.out.println(student.score);
        student.study();
        student.sleep();
        System.out.println(student);
    }

}

//学生类
class Student {

    String name;
    int age;
    String sex;
    double score;

    //方法
    public void study() {
        System.out.println("哪有什么天才啊，我都是把别人刷B 站的时间，都花在学习上");
    }
    public void sleep() {
        System.out.println("你怎么睡得着的");
    }
}
