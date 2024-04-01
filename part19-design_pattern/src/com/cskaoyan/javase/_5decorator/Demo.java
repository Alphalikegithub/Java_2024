package com.cskaoyan.javase._5decorator;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 装饰器类
 * @since 2024-03-19 08:17
 **/

public class Demo {
    public static void main(String[] args) {
        //先要一杯基础款的奶茶
        System.out.println("基础款奶茶-----");
        MilkTea milkTea = new MilkTea();
        milkTea.add();
        System.out.println("珍珠奶茶-------");
        DecoratorA decoratorA = new DecoratorA();
        decoratorA.setBeverage(milkTea);
        decoratorA.add();
        System.out.println("全套奶茶-------");
        DecoratorB decoratorB = new DecoratorB();
        decoratorB.setBeverage(decoratorA);
        decoratorB.add();
    }
}
