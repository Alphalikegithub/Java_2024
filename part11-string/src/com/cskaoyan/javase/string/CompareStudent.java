package com.cskaoyan.javase.string;

import java.util.Arrays;

/**
 * @program: Java_2024
 * @description: 定义一个学生类，让其按照学生年龄的大小，从小到大进行排序
 * @create: 2024-02-29 16:31
 **/

public class CompareStudent {
    public static void main(String[] args) {
        //创建学生对象
        Student s1 = new Student("zhangsan", 20, 58);
        Student s2 = new Student("lisi", 19, 60);
        Student s3 = new Student("wangwu", 18, 78);
        Student s4 = new Student("zhangmazi", 17, 99);
        Student s5 = new Student("lihua", 17, 100);
        //填充数组
        Student[] students = {s1, s2, s3, s4,s5};
        //排序前
        System.out.println(Arrays.toString(students));
        //Arrrys.sort进行排序
        Arrays.sort(students);
        //排序后
        System.out.println(Arrays.toString(students));
    }
}

class Student implements Comparable<Student> {
    @Override
    public int compareTo(Student o) {
//        //按照年龄从小到大进行排序
//        return this.getAge() - o.getAge();
        //先按照年龄排序，如果年龄相同，按照分数从高到低进行排序
        //按照分数高低从小到大进行排序
        if (this.getAge() == o.getAge()) {
            return o.getScore() - this.getScore();
        }
        return this.getAge() - o.getAge();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    String name;
    int age;
    int score;

    public Student(int score) {
        this.score = score;
    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }
}
