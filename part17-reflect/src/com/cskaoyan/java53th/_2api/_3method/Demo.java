package com.cskaoyan.java53th._2api._3method;

import com.cskaoyan._2reflect._2api.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 用反射操作对象的成员方法
 *
 * @since 14:30
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Class<?> stuClazz = Class.forName("com.cskaoyan._2reflect._2api.Student");
        Constructor<?> constructor = stuClazz.getConstructor(int.class, int.class, String.class, double.class);
        Student s = (Student) constructor.newInstance(100, 200, "zs", 666);
        System.out.println(s);

        Method[] declaredMethods = stuClazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("---------------------");
        Method[] methods = stuClazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("---------------------------");
        Method testMethod = stuClazz.getDeclaredMethod("test", int.class, double.class);
        testMethod.setAccessible(true);
        Object result = testMethod.invoke(s, 100, 0.1);
        System.out.println(result);
    }
}
