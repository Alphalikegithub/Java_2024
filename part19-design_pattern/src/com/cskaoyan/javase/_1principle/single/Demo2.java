package com.cskaoyan.javase._1principle.single;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 单一职责原则，一个类只做一件事情
 * @since 2024-03-18 15:46
 **/

public class Demo2 {
    public static void main(String[] args) {
        RoadAnimal roadAnimal = new RoadAnimal();
        roadAnimal.eat("狮子");
        SwimAnimal swimAnimal = new SwimAnimal();
        swimAnimal.eat("海豚");
        FlyAnimal flyAnimal = new FlyAnimal();
        flyAnimal.eat("秃鹫");


    }
}

//定义地上跑的动物
class RoadAnimal {
    public void eat(String animal) {
        System.out.println(animal + "在地上捕食");
    }
}
//定义水里游的动物
class SwimAnimal{
    public void eat(String animal) {
        System.out.println(animal + "在水里捕食");
    }
}
//定义天上飞的动物
class FlyAnimal{
    public void eat(String animal) {
        System.out.println(animal + "在空中捕食");
    }
}
