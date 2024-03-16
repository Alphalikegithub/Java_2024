package com.cskaoyan.javase._0introduction;

/**
 * @author DOC
 * @program: Java_2024
 * @description: 注解
 * @since 2024-03-16 17:24
 **/

public class Demo {
    public static void main(String[] args) {
        func2();
    }
    @Deprecated
    public static void func2(){}
}
class Father{
    public void func(){

    }
}
class Son extends Father{
    @Override
    public void func() {
        super.func();
    }
}
