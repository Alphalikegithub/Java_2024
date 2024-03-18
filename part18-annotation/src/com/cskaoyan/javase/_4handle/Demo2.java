package com.cskaoyan.javase._4handle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-18 09:36
 **/

public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException {
        //先获取User类中所有的成员变量
        Class<?> aClass = Class.forName("com.cskaoyan.javase._4handle.User");
        Field[] declaredFields = aClass.getDeclaredFields();
        //遍历之前先判断User类是否使用注解
        boolean annotationPresent = aClass.isAnnotationPresent(Myannotation.class);
        if(annotationPresent){
            //使用了注解再进行下一步操作
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField);
                //判断有没有int id这个成员变量
                //成员变量的数据类型
                String simpleName = declaredField.getType().getSimpleName();
                //成员变量的名字
                String name = declaredField.getName();
                if(("int").equals(simpleName)&& "id".equals(name)){
                    System.out.println("存在int id这个成员变量");
                }
            }
        }else{
            System.out.println("User这个类没有使用注解");
        }

    }
}
/*
Myannotation用来修饰类
要求被修饰的类中有一个int类型的成员变量
并且成员变量的名字叫做id
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Myannotation{
    String value() default "";
}
@Myannotation
class User{
    int id;
    String name;
    int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
