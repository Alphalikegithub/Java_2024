package com.cskaoyan.javase._5classLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: Java_2024
 * @description: 自定义类加载器
 * @create: 2024-03-16 15:35
 **/
//用自己定义的类加载器去加载指定的文件  并执行这个类中的方法
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //定义要加载的class文件的路径
        String classPath = "D:\\Java\\IdeaProjects\\Java_2024\\part17-reflect\\src\\com\\cskaoyan\\javase\\test\\Log.class";
        //创建自己定义的类加载器
        MyClassLoader myClassLoader = new MyClassLoader(classPath);
        //加载类 loadClass()方法
        Class<?> logClass = myClassLoader.loadClass("Log");

        //查看使用的是哪个类加载器
        System.out.println(logClass.getClassLoader());
        //通过字节码文件对象去获取类中的成员方法
        Method method= logClass.getDeclaredMethod("func");
        //执行这个方法
        Constructor<?> declaredConstructor = logClass.getDeclaredConstructor();
        Object o = declaredConstructor.newInstance();
        method.invoke(o);
    }
}
