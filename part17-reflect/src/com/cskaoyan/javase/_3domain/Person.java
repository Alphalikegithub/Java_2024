package com.cskaoyan.javase._3domain;

/**
 * @program: Java_2024
 * @description: Person类
 * @create: 2024-03-16 10:12
 **/

public class Person {
    public String name;
    private int age;
    boolean gender;

    public Person() {
    }

    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("吃了...");
    }
    private void eat(String food){
        System.out.println("吃了" + food);
    }
}
