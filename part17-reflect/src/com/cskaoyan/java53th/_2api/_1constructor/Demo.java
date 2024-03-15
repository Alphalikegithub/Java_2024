package com.cskaoyan.java53th._2api._1constructor;

import com.cskaoyan._2reflect._2api.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 首先第一步还是获取Class对象
 * 然后通过Class对象获取该类型的构造器
 * 最后可以利用此构造器创建该类型的对象
 * 在这个过程中,可以破解私有权限
 *
 * @since 11:37
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> stuClazz = Class.forName("com.cskaoyan._2reflect._2api.Student");
        /*
            Class类的API中
            所有带有Declared的方法表示可以获取所有权限的此结构
            不带Declared的方法表示只能获取public权限的此结构

            所有带有"s"的方法表示获取符合要求的所有的此结构(带s肯定就没有参数了,获取所有)
            所有不带有"s"的方法表示获取符合要求的一个结构(不带s肯定要带参数,参数用于唯一确定一个结构)
         */
        Constructor<?>[] declaredConstructors = stuClazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        System.out.println("----------------------------------------");
        Constructor<?>[] constructors = stuClazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("----------------------------------------");
        Constructor<?> constructor2 = stuClazz.getConstructor(int.class, int.class, int.class, int.class);
        System.out.println(constructor2);

        System.out.println("----------------------------------------");
        Constructor<?> constructor = stuClazz.getConstructor(int.class, int.class, String.class, double.class);
        System.out.println(constructor);
        System.out.println("---------------------------------------");
        Constructor<?> constructor1 = stuClazz.getDeclaredConstructor();
        System.out.println(constructor1);

        // 构造器对象获取完毕后,可以用于创建对象
        // 传入相应参数，在创建对象过程中赋值，返回值是一个相应对象
        // T newInstance(Object... initargs)
        Student s = (Student) constructor2.newInstance(1, 2, 3, 4);
        System.out.println(s);

        // 此构造器权限是私有的,所以不能直接用,需要先破解权限
        constructor1.setAccessible(true);
        Student s2 = (Student) constructor1.newInstance();
        System.out.println(s2);

        // 获取int单参构造器
        Constructor<?> constructor3 = stuClazz.getDeclaredConstructor(int.class);
        constructor3.setAccessible(true);
        Student s3 = (Student) constructor3.newInstance(100);
        System.out.println(s3);
    }
}
