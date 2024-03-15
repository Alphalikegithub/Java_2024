package com.cskaoyan.java53th._3other;


import java.lang.reflect.Field;

/**
 * 反射的举例
 * @since 14:39
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> b = Class.forName("com.cskaoyan._2reflect._3other.B");
        Class<?> a = b.getSuperclass();
        Field[] declaredFields = a.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }
}

class A {
    private int num;
}

class B extends A {
}
