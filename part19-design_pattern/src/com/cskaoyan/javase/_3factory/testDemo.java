package com.cskaoyan.javase._3factory;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-18 22:49
 **/

public class testDemo {
    @Test
    public void myTest1() throws IllegalAccessException {
        //调用工厂里的方法去创建对象
        Fruit apple = FruitFactory.getInstance("apple");
        System.out.println(apple);
        Fruit banana = FruitFactory.getInstance("banana");
        System.out.println(banana);
    }
    @Test
    public void myTest2() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Fruit fruit1 = FruitFactory.getInstance2("com.cskaoyan.javase._3factory.Apple");
        Fruit fruit2 = FruitFactory.getInstance2("com.cskaoyan.javase._3factory.Banana");
        Fruit fruit3 = FruitFactory.getInstance2("com.cskaoyan.javase._3factory.Orange");
        System.out.println(fruit1);
        System.out.println(fruit2);
        System.out.println(fruit3);
    }

    @Test
    public void myTest3(){
        TeslaFactory teslaFactory = new TeslaFactory();
        Car car = teslaFactory.createrCar();
        System.out.println(car);
        AudiFactory audiFactory = new AudiFactory();
        Car car1 = audiFactory.createrCar();
        System.out.println(car1);
    }
}
