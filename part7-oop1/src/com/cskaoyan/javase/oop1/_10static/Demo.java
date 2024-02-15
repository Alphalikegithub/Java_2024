package com.cskaoyan.javase.oop1._10static;

/**
 * @program: Java_2024
 * @description: 静态变量
 * @create: 2024-01-16 10:03
 **/
//静态成员不应该使用对象引用访问
//正确的方法：使用 类名.静态变量 去访问
public class Demo {
    public static void main(String[] args) {
        System.out.println(Student.name);
        Student.study();
        testStatic();
        //匿名对象
        new Student().sleep();
        Student student1 = new Student();
        //Static member 'com.cskaoyan.javase.oop1._10static.Student.study()' accessed via instance reference
        student1.study();
        student1.sleep();
    }
   public  static  void testStatic(){
       System.out.println("我是Demo类的静态成员方法");
   }
}

class Student {
    static String name = "爱学Java的小明";

    public static void study() {
        System.out.println("我是Student类静态成员方法");
    }
    public void sleep(){
        System.out.println("测试匿名对象");
    }
}
