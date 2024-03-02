package com.cskaoyan.javase._1handle;

/**
 * @program: Java_2024
 * @description: 单独处理除0异常，空指针异常和数组下标越界异常一起处理
 * @create: 2024-02-29 23:24
 **/

public class Demo1 {
    public static void main(String[] args) {

    }
    public static void func() throws CloneNotSupportedException{
        //throws + 编译时异常，意味着不在本方法中处理，交给方法的调用者去处理
        Demo1 demo1 = new Demo1();
        demo1.clone();
    }
}
