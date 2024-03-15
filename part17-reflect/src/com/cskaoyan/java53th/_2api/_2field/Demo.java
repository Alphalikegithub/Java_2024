package com.cskaoyan.java53th._2api._2field;

import com.cskaoyan._2reflect._2api.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 用反射操作对象当中的成员变量
 *
 * @since 14:24
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Class<?> stuClazz = Class.forName("com.cskaoyan._2reflect._2api.Student");
        Constructor<?> constructor = stuClazz.getConstructor(int.class, int.class, String.class, double.class);
        Student s = (Student) constructor.newInstance(100, 200, "zs", 666);
        System.out.println(s);

        Field[] declaredFields = stuClazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        Field num = stuClazz.getDeclaredField("num");
        num.setAccessible(true);
        num.set(s, 1000);
        System.out.println(s);

        System.out.println(num.get(s));
    }
}
