package com.cskaoyan.javase._2throws;

/**
 * @program: Java_2024
 * @description: throws抛出异常
 * @create: 2024-02-29 23:36
 **/

public class Demo2 {
    public static void main(String[] args) {

    }
}

class Father {
    public void m1() throws CloneNotSupportedException {
        // ...
    }
    public void m2() throws ArithmeticException{

    }
}
class Son extends Father {
    @Override
    public void m1() throws CloneNotSupportedException {
        super.m1();
        //子类重写父类方法的时候 不能抛出比父类更多的编译时异常
        //建议异常类型与父类保持一致
    }

    @Override
    public void m2() throws ArithmeticException,NullPointerException {
        super.m2();
    }
}
