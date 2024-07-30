package com.javaCollection.list.ArrayList;

import java.util.ArrayList;

/**
 * @author alpha
 * @program: Java_2024
 * @description: list的clone方法
 * @since 2024-07-29 09:18
 **/

public class DemoArraylist2 {
    public static void main(String[] args) {
        User zs = new User("zs", 18);
        ArrayList<User> users = new ArrayList<>();
        users.add(zs);

        ArrayList<User> clone = (ArrayList<User>) users.clone();
        zs.name = "aa";

        System.out.println(users);
        System.out.println(clone);

    }
}
class User{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}