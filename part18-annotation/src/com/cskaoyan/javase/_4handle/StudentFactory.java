package com.cskaoyan.javase._4handle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-18 10:00
 **/

public class StudentFactory {
    static Class stuCls;

    static {
        try {
            stuCls = Class.forName("com.cskaoyan.javase._4handle.Student");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //定义1个方法专门用于产生学生对象
    public Student getInstance(String name, int age) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //判断学生姓名的长度
        judgeName(name);
        //判断学生年龄大小是否在18-25内
        judgeAge(age);
        //获取构造方法
        Constructor declaredConstructor = stuCls.getDeclaredConstructor(String.class, int.class);
        //暴力破解
        declaredConstructor.setAccessible(true);
        //实例化对象(强制转换数据类型)
        //Object o = declaredConstructor.newInstance(name, age);
        Student student= (Student) declaredConstructor.newInstance(name, age);

        //最终是返回1个满足要求的学生对象
        return student;
    }

    private static void judgeAge(int age) throws NoSuchFieldException, IllegalAccessException {
        Field ageField = stuCls.getDeclaredField("age");
        boolean annotationPresent = ageField.isAnnotationPresent(AgeLimit.class);
        if (annotationPresent) {
            AgeLimit ageLimit = ageField.getAnnotation(AgeLimit.class);
            //获取属性值
            int maxAge = ageLimit.maxAge();
            int minAge = ageLimit.minAge();
            //进行判断
            if (age < minAge || age > maxAge) {
                throw new IllegalAccessException("年龄不合法");
            }
        }
    }

    private static void judgeName(String name) throws NoSuchFieldException, IllegalAccessException {
        boolean annotationPresent = stuCls.isAnnotationPresent(NameLimit.class);
        Field nameField = stuCls.getDeclaredField("name");
        if (annotationPresent) {
            NameLimit nameLimit = nameField.getAnnotation(NameLimit.class);
            //获取属性值
            int i = nameLimit.limitLength();
            //进行判断
            if (name.length() <= i) {
                throw new IllegalAccessException("名字不符合要求");
            }
        }
    }
}
