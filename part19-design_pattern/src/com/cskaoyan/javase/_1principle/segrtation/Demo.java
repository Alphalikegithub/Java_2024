package com.cskaoyan.javase._1principle.segrtation;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 接口隔离原则：一个接口不需要提供太多的行为
 * @since 2024-03-18 16:02
 **/

public class Demo {
    public static void main(String[] args) {

    }
}
interface MyInterface{
    //定义了一个大接口
    void func1();
    void func2();
    void func3();
}
class MyClass implements MyInterface{
    //如果需要使用func1()，必须实现其他两个方法func2()和func3()
    @Override
    public void func1() {

    }

    @Override
    public void func2() {

    }

    @Override
    public void func3() {

    }


}
