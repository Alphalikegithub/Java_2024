package com.cskaoyan.javase._4handle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 提取注解里面的信息
 * @since 2024-03-18 09:20
 **/

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        System.out.println(1111);
        //利用反射获取注解信息
        Class<?> aClass = Class.forName("com.cskaoyan.javase._4handle.Demo");
        Method method = aClass.getDeclaredMethod("func");
        //先判断方法是否使用了注解
        boolean annotationPresent = method.isAnnotationPresent(Login.class);
        if(annotationPresent){
            //如果使用了注解 再去获取属性值getAnnotation()
            Login login = method.getAnnotation(Login.class);
            //获取属性值
            String username = login.username();
            String password = login.password();
            System.out.println("username = " + username);
            System.out.println("password = " + password);
        }
    }

    @Login
    public void func(){

    }
}
//使用元注解修饰
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Login{
    String username() default "root";
    String password() default "123456";
}
