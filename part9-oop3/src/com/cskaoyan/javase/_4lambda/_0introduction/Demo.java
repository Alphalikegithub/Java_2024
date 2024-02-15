package com.cskaoyan.javase._4lambda._0introduction;

/**
 * @program: Java_2024
 * @description: Lambda表达式
 * @create: 2024-01-27 08:37
 **/

public class Demo {
    public static void main(String[] args) {
        IA ia =a-> a + "hello,world";
        System.out.println(ia.test(100));
    }
}
@FunctionalInterface
interface IA{
    String test(int a);
}
class A{
    //如果是这种形式的话，虽然B没有直接继承Qbject类

    @Override
    public int hashCode() {
        /*suoyoudejavadaimadezhixingdouzaijvmfangfazhongzhisuijiaobendifangfashiyinweijavadejuxianxing既然本地代码是Java方法实现的*/
        return 0;
    }
}