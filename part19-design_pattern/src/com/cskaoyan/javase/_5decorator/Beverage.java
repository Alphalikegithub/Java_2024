package com.cskaoyan.javase._5decorator;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 抽象饮料类
 * @since 2024-03-19 08:17
 **/

public abstract class Beverage {
    //定义专门添加小料的方法
    abstract void add();
}
//定义奶茶类
class MilkTea extends Beverage{

    @Override
    void add() {
        //最基础的奶茶 加冰
        System.out.println("老板，来一杯加冰的奶茶");
    }
}
//定义抽象的装饰器类
abstract class Decorator extends Beverage{
    //成员变量
    Beverage beverage;

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }
    //重写父类add方法
    @Override
    void add() {
        beverage.add();
    }
}
//具体的装饰器
class DecoratorA extends Decorator{
    @Override
    void add() {
        super.add();
        addZz();
    }

    private void addZz() {
        System.out.println("再加点珍珠");
    }

}
class DecoratorB extends Decorator{
    @Override
    void add() {
        super.add();
        addYg();
    }

    private void addYg() {
        System.out.println("再加点椰果");
    }
}