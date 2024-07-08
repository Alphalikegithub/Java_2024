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
    public boolean push(T t){
        //在添加方法中，考虑数组是否满了，满了就扩容
        if(size == objects.length){
            int newLen = getLen();//获取新的数组的长度
            grow(newLen);//根据新数组的长度进行扩容
        }
        //核心逻辑
        objects[size] = t;
        size ++;
        return true;
    }

    private void grow(int newLen) {
        Object[] newObjects = new Object[newLen];
        //把旧数组中的数据转移到新数组
        for (int i = 0; i < objects.length; i++) {
            newObjects[i] = objects[i];
        }
        objects = newObjects;
    }

    private int getLen() {
        int oldLen = objects.length;
        int newLen = oldLen * 2;
        //之所以判断newLen < 0，是因为可能存在溢出情况，int类型溢出后，newLen的值可能为负
        if(newLen < 0 || newLen > MAX_CAPACITY){
            newLen = MAX_CAPACITY;
        } else if (newLen == oldLen) {
            throw new RuntimeException("newLen = oldLen");

        }
        return  newLen;
    }
    //pop

    //remove

}
