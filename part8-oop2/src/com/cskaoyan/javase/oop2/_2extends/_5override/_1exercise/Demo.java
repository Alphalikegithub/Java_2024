package com.cskaoyan.javase.oop2._2extends._5override._1exercise;

/**
 * @program: Java_2024
 * @description: 方法重写的语法
 * @create: 2024-01-17 17:10
 **/
/*
* 重写方法推荐使用快捷键
* Alt + Insert*/
public class Demo {
    public static void main(String[] args) {

    }
}
class Phone{
    public void call(){
        System.out.println("我用手机打电话");
    }
    void test2(){

    }
    public void test3(){

    }
}
class IPhone extends Phone{
    @Override
    public void call(){
        System.out.println("嘿！siri");
    }
    @Override
    //子类重写父类的方法，访问权限修饰符只能修改的更宽松，不能更严格
    public void test2(){

    }

    @Override
    public void test3() {
        super.test3();
    }
}
