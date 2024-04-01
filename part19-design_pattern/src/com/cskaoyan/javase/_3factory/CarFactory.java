package com.cskaoyan.javase._3factory;
//工厂方法模式中抽象工厂类负责定义创建对象的接口,具体对象的创建工作由继承抽象工厂的具体类实现
/**
 * @author alpha
 * @program: Java_2024
 * @description: 抽象的汽车工厂
 * @since 2024-03-18 23:19
 **/

public abstract class CarFactory {
    //定义一个生产汽车的方法
    abstract Car createrCar();
}
//定义具体的工厂
class TeslaFactory extends CarFactory{
    @Override
    Car createrCar() {
        return new Tesla();
    }
}
class AudiFactory extends CarFactory{

    @Override
    Car createrCar() {
        return new Audi();
    }
}
