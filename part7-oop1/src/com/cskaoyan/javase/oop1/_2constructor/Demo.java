package com.cskaoyan.javase.oop1._2constructor;

/**
 * @program: Java_2024
 * @description: 构造器
 * @create: 2024-01-15 23:28
 **/

public class Demo {
    public static void main(String[] args) {
        Teacher t = new Teacher("日语",56);
        /*t.m_course = "JavaSE";
        t.m_age = 12;*/
        Teacher t2 = new Teacher("英语",58);
        /*t2.m_course = "C++";
        t2.m_age = 38;*/
        t.teach();
        t2.teach();
    }
}

//构造方法的名字和类名保持完全一致
//类名和构造方法名书写规范都是大驼峰
class Teacher {
    String m_course;
    int m_age;

    public Teacher(String course,int age) {
        this.m_age = age;
        this.m_course = course;
    }



    public void teach() {
        System.out.println(m_age + "岁的老师，在讲" + m_course);
    }
}