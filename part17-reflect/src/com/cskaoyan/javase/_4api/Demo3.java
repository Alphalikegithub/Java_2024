package com.cskaoyan.javase._4api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: Java_2024
 * @description: 获取类中的成员方法
 * @create: 2024-03-16 15:06
 **/

public class Demo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> personClass = Class.forName("com.cskaoyan.javase._3domain.Person");
        //还能获取父类的public 方法
        System.out.println("获取所有的带public的成员方法，包括父类的public 方法:");
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("获取所有的成员方法:");
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("获取指定的成员方法:");
        Method eatMethod1 = personClass.getMethod("eat");
        System.out.println(eatMethod1);
        System.out.println("获取指定的成员方法,不管是不是public:");
        Method eatMethod2 = personClass.getDeclaredMethod("eat", String.class);
        System.out.println(eatMethod2);

        //通过反射去执行上面的方法(利用Method调用对象的方法)
        //
        //对象呢怎么来？
        //1.h获取构造方法
        //2.实例化对象
        //3.对带有指定参数的指定对象调用由此Method对象表示的底层方法
        Constructor<?> declaredConstructor = personClass.getDeclaredConstructor();
        Object o = declaredConstructor.newInstance();
        eatMethod1.invoke(o);
        //private方法需要忽略语法检查 暴力破解
        eatMethod2.setAccessible(true);
        eatMethod2.invoke(o,"apple");
    }
}
