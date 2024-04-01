package com.cskaoyan.javase._3factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 水果工厂
 * @since 2024-03-18 22:39
 **/

public class FruitFactory {
    //提供一个静态方法，用于返回水果对象
    public static Fruit getInstance(String name) throws IllegalAccessException {
        Fruit fruit = null;
        if("apple".equals(name)){
            fruit = new Apple();
        }else if("banana".equals(name)){
            fruit = new Banana();
        }else{
            throw new IllegalAccessException("设备有限 无法生产");
        }
        return fruit;
    }

    //利用反射去改进代码 以使得程序符合开闭原则
    public static Fruit getInstance2(String className) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //className应该是全限定类名
        Class<?> aClass = Class.forName(className);
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        //创建对象
        Fruit fruit = (Fruit) declaredConstructor.newInstance();
        //最终返回的还是水果的具体对象

        return fruit;
    }
}
