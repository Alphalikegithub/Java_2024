package com.cskaoyan.java53th._2api;

/**
 * 被测试的学生类
 * @since 11:38
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Student {
    private int num;
    int num2;
    protected int num3;
    public int num4;
    String name;
    protected double score;

    private Student() {
    }

    Student(int num, int num2) {
        this.num = num;
        this.num2 = num2;
    }

    protected Student(int num) {
        this.num = num;
    }

    public Student(int num, int num2, int num3, int num4) {
        this.num = num;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
    }

    public Student(int num, int num2, String name, double score) {
        this.num = num;
        this.num2 = num2;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "num=" + num +
                ", num2=" + num2 +
                ", num3=" + num3 +
                ", num4=" + num4 +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    private void test(int num) {
        System.out.println("int method");
    }

    protected void test(int num, double num2) {
        System.out.println("int double method");
    }

    void test() {
        System.out.println("default method");
    }
}
