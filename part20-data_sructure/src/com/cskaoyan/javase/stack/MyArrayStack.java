package com.cskaoyan.javase.stack;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 用数组实现一个栈
 * @since 2024-07-05 14:39
 **/

public class MyArrayStack <T> {
    //在底层代码中常见的数组大小是10或16
    private static final int INIT_CAPACITY = 10;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;
    //相比链表，数组有两个费中重要的不同之处（一、数组需要初始化 二、数组需要扩容）
    private Object[] objects;
    private int size;
    public MyArrayStack(){
        this.objects = new Object[INIT_CAPACITY];
    }
    //带参的构造函数
    public MyArrayStack(int initCapacity){
        if(initCapacity < 1 || initCapacity > MAX_CAPACITY){
            throw new IllegalArgumentException("param is Illegal");
        }
        this.objects = new Object[initCapacity];
    }
    //push
    //pop
    //remove

}
