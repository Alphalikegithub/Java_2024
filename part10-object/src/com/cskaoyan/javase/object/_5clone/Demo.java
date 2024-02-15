package com.cskaoyan.javase.object._5clone;

/**
 * @program: Java_2024
 * @description: clone方法
 * @create: 2024-02-08 10:33
 **/

public class Demo {
    public static void main(String[] args) {
        Student s1 = new Student(18, 100);
        Student s2 = new Student(20, 88);
        System.out.println(s1.age + s1.score);
        System.out.println(s1.toString());
    }
}

class Student {
    int age;
    double score;

    public Student(int age, double score) {
        this.age = age;
        this.score = score;
    }
}
