package com.cskaoyan.javase.object._5clone;

/**
 * @program: Java_2024
 * @description: 深度克隆练习
 * @create: 2024-02-12 11:59

 * 深度克隆练习：请完成类FirstLevel的深度克隆。
 *
 * 现在有三个类 FirstLevel 、SecondLevel 、ThirdLevel
 *
 * 对于String这个引用数据类型,需不需要做深度克隆呢?
 *      不需要,因为String对象是不可变的,一旦改变会创建一个新的String对象,原先的String对象不变
 *
 * @since 17:03
 * @author wuguidong@cskaoyan.onaliyun.com
 */

/*现在有3个类FirstLevel  SecondLevel ThirdLevel*/
public class Demo2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        /*FirstLevel first = new FirstLevel(10, 20, new SecondLevel(100, 200, new ThirdLevel(1000, 2000)));
        FirstLevel cloneFirst = first.clone();
        first.second.third.thirdIntValue = 8888;
        System.out.println(cloneFirst.second.third.thirdIntValue);*/

        FirstLevel first = new FirstLevel(10, 20, new SecondLevel(100, 200, new ThirdLevel(1000, 2000, "hello")));
        FirstLevel cloneFirst = first.clone();
        first.second.third.value = "world";
        System.out.println(cloneFirst.second.third.value);

    }
}

class FirstLevel implements Cloneable {
    int firstIntValue;
    double firstDoubleValue;
    SecondLevel second;

    public FirstLevel() {
    }

    public FirstLevel(int firstIntValue, double firstDoubleValue, SecondLevel second) {
        this.firstIntValue = firstIntValue;
        this.firstDoubleValue = firstDoubleValue;
        this.second = second;
    }

    @Override
    protected FirstLevel clone() throws CloneNotSupportedException {
        // 1.深度克隆是在浅克隆基础上完成的
        FirstLevel cloneFirst = (FirstLevel) super.clone();
        // 2.把second引用指向的对象克隆一份
        // 3.把克隆的second引用指向克隆的second对象
        cloneFirst.second = second.clone();
        return cloneFirst;
    }
}

class SecondLevel implements Cloneable {
    int secondIntValue;
    double secondDoubleValue;
    ThirdLevel third;

    public SecondLevel() {
    }

    public SecondLevel(int secondIntValue, double secondDoubleValue, ThirdLevel third) {
        this.secondIntValue = secondIntValue;
        this.secondDoubleValue = secondDoubleValue;
        this.third = third;
    }

    @Override
    protected SecondLevel clone() throws CloneNotSupportedException {
        // 1.深度克隆是在浅克隆基础上完成的
        SecondLevel cloneSecond = (SecondLevel) super.clone();
        // 2.把third指向的对象,克隆一份
        // 3.把克隆third引用指向克隆的third对象
        cloneSecond.third = third.clone();
        return cloneSecond;
    }
}

class ThirdLevel implements Cloneable {
    int thirdIntValue;
    double thirdDoubleValue;

    String value;


    public ThirdLevel() {
    }

    public ThirdLevel(int thirdIntValue, double thirdDoubleValue) {
        this.thirdIntValue = thirdIntValue;
        this.thirdDoubleValue = thirdDoubleValue;
    }

    public ThirdLevel(int thirdIntValue, double thirdDoubleValue, String value) {
        this.thirdIntValue = thirdIntValue;
        this.thirdDoubleValue = thirdDoubleValue;
        this.value = value;
    }

    @Override
    protected ThirdLevel clone() throws CloneNotSupportedException {
        return ((ThirdLevel) super.clone());
    }
}