package com.cskaoyan.javase._4api;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @program: Java_2024
 * @description: 补充API
 * @create: 2024-03-16 15:23
 **/

public class Demo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> personClass = Class.forName("com.cskaoyan.javase._3domain.Person");
        //获取类的名字（全类名）
        System.out.println("类的名字（全类名）");
        System.out.println(personClass.getName());
        //获得类的名字（简单的名字）
        System.out.println("类的名字（简单的名字）");
        System.out.println(personClass.getSimpleName());
        //获取父类
        System.out.println("父类");
        System.out.println(personClass.getSuperclass());
        //获取接口
        System.out.println("接口");
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        //获取权限修饰符
        System.out.println("权限修饰符");
        //1表述public 2表示
        Field nameField = personClass.getDeclaredField("name");
        int modifiers = nameField.getModifiers();
        System.out.println(modifiers);
        //返回描述指定修饰符中的修饰符标志的字符串
        System.out.println("返回描述指定修饰符中的修饰符标志的字符串");
        System.out.println(Modifier.toString(modifiers));
        //获取类型
        Class<?> type = nameField.getType();
        System.out.println(type);

        //查看类加载器
        System.out.println(personClass.getClassLoader());
    }
}
