package com.cskaoyan.javase._1principle.single;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 单一职责原则
 * @since 2024-03-18 15:41
 **/

public class Demo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat("dog");
        animal.eat("fish");
        animal.eat("bird");
    }
}
//定义一个Animal类
class Animal{
    public void eat(String animal){
        System.out.println(animal + "在地上捕食");
    }
}