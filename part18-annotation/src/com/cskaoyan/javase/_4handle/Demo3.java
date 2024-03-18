package com.cskaoyan.javase._4handle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;

/**
 * @author alpha
 * @program: Java_2024
 * @description:* 定义一个Student对象，年龄在18-25之间，名字长度不超过4
 *  * 定义一个注解AgeLimit 有2个属性 1个maxAge另一个是minAge
 *  * 定义一个注解NameLimit 有1个属性 int limitLength() default 4
 * @since 2024-03-18 09:53
 **/

public class Demo3 {
    public static void main(String[] args) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
//        Student student = new Student("adadada", 45);
//        System.out.println(student);
        //创建StudentFactory
        StudentFactory studentFactory = new StudentFactory();
        Student student = studentFactory.getInstance("huhuhuhyuyuyuiyuiyhiu", 20);
        System.out.println(student);
    }
}
class Student{
    //给成员变量添加注解
    @NameLimit(limitLength = 4)
    String name;
    //给成员变量添加注解
    @AgeLimit
    int age;

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
//定义注解
//(使用元注解 指定注解的作用范围)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface AgeLimit{
    int  maxAge() default 25;
    int minAge() default 18;
}
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface NameLimit{
    //属性 表名字的最大长度
    int limitLength() default 4;
}