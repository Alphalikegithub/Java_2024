package com.cskaoyan.javase.oop1._1reference;

/**
 * @program: Java_2024
 * @description: 重新认识引用数据类型
 * @create: 2024-01-15 21:30
 **/

public class Demo {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher();
        Teacher teacher2 = teacher1;
        Teacher teacher3 = new Teacher();
        teacher1.runAway();
        teacher1.runAway();
        System.out.println(teacher1 == teacher2);
        System.out.println(teacher1 == teacher3);
        teacher1.age = 28;
        System.out.println(teacher1.age);
    }
}

//创建Teacher类型
class Teacher {
    String name;
    int age;
    double salary;

    //行为
    public void teach() {
        System.out.println("教JAVASE");
    }

    public void runAway() {
        System.out.println("提桶跑路");
    }
}