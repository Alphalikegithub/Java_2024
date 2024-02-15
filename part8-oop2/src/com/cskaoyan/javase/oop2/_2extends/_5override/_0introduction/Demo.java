package com.cskaoyan.javase.oop2._2extends._5override._0introduction;

/**
 * @program: Java_2024
 * @description: 方法的覆盖/方法的重写
 * @create: 2024-01-17 16:50
 **/

public class Demo {
    public static void main(String[] args) {
        Son son = new Son();
        son.test();
        son.invokeFatherTest();
        son.invokeFatherTestBySuper();
    }
}

class Father {
    public void test() {
        System.out.println("father");
    }

    public void invokeFatherTest() {
        test();
    }
}

class Son extends Father {
    public void test() {
        System.out.println("son");
    }
    public void invokeFatherTestBySuper() {
        super.test();
    }
}
