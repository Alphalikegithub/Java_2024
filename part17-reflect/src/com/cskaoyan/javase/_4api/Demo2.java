package com.cskaoyan.javase._4api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: Java_2024
 * @description: 获取成员变量
 * @create: 2024-03-16 10:44
 **/

public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*起点：获取字节码文件对象*/
        Class<?> personClass = Class.forName("com.cskaoyan.javase._3domain.Person");
        //通过反射获取成员变量
        //1.获取所有成员变量
        System.out.println("获取所有的成员变量:");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field d : declaredFields) {
            System.out.println(d);
        }

        System.out.println("获取所有的带public的成员变量:");
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //2.获取指定成员变量
        System.out.println("获取指定的带public的成员变量:");
        Field nameField = personClass.getField("name");
        System.out.println(nameField);

        //获取成员变量的值
        System.out.println("打印成员变量的值");
        //1.先获取构造方法
        Constructor<?> declaredConstructor = personClass.getDeclaredConstructor();
        //2.再实例化对象
        Object o = declaredConstructor.newInstance();
        nameField.set(o,"hahha");
        System.out.println(o);

        //获取值，传入对象
        Object o1 = nameField.get(o);
        System.out.println(o1);
        //值的引用传递

    }
}
