package com.cskaoyan.javase.object._1getclass;

/**
 * @program: Java_2024
 * @description: Object类中的getClass方法
 * @create: 2024-01-29 20:40
 **/

public class Demo {
    public static void main(String[] args) {
        Student s = new Student();
        Class stuClazz = s.getClass();//获取该类型的类型信息
        Student s2 = new Student();
        Class  s2Class = s2.getClass();
        System.out.println(stuClazz == s2Class);
        System.out.println(s2Class.getName());
    }
}
class Student{
    //类加载的过程中 ，创建静态声明
    int a;
    //JVM在类加载时期会在堆上创建一个对象
    public void test(){
        //class对象叫做运行时类对象,他的作用是程序的运行期间，帮助程序员获取类型信息。
        //在程序的运行过程中在堆上创建对象
        //3.细节问题Class 是JVM创建的，不是由getClass方法创建
    //类型转换
    }
}