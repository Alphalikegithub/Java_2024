package com.cskaoyan.javase._0abstract._0introduction;

/**
 * @program: Java_2024
 * @description: 抽象类
 * @create: 2024-01-18 23:13
 **/
/*良缘由夙缔，佳偶自天成
祝你和姐夫：
凤翥鸾翔，山遥水长。
白头共赴，长乐未央
新婚快乐！😄*/
public class Demo {
    public static void main(String[] args) {
        Animal animal;
        animal = new Dog();
        animal.shout();
        animal = new Cat();
        animal.shout();

    }
}

abstract class Animal {
    public abstract void shout();
}

class Dog extends Animal {
    @Override
    public void shout() {
        System.out.println("狗叫");
    }
}

class Cat extends Animal {
    @Override
    public void shout() {
        System.out.println("猫叫");
    }
}
