package com.cskaoyan.javase._4api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: Java_2024
 * @description: 通过反射获取一个类的构造方法
 * @create: 2024-03-16 10:16
 **/

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取所有的构造方法
        //1.先获取字节码文件对象
        Class<?> personClass = Class.forName("com.cskaoyan.javase._3domain.Person");
        //2.Constructor[] getConstructors()
        System.out.println("获取所有的public构造方法");
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c);
        }
        System.out.println("获取所有声明过的构造方法");
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> c : declaredConstructors) {
            System.out.println(c);
        }
        System.out.println("获取指定的public的构造方法");
        System.out.println("无参构造方法");
        Constructor<?> noneconstructor = personClass.getConstructor();
        System.out.println(noneconstructor);
        System.out.println("三参构造方法");
        Constructor<?> threeconstructor = personClass.getConstructor(String.class, int.class, boolean.class);
        System.out.println(threeconstructor);
        System.out.println("两参的私有的构造方法");
        Constructor<?> twodeclaredConstructor = personClass.getDeclaredConstructor(String.class, int.class);
        System.out.println(twodeclaredConstructor);
        System.out.println("使用Constructor来创建对象");
        Object o = noneconstructor.newInstance();
        System.out.println(o);
        Object o1 = threeconstructor.newInstance("hah", 20, true);
        System.out.println(o1);

        //暴力破解(私有构造方法) 忽略Java的语法检查
        twodeclaredConstructor.setAccessible(true);
        Object o2 = twodeclaredConstructor.newInstance("caixuk", 18);
        System.out.println(o2);


    }
}
