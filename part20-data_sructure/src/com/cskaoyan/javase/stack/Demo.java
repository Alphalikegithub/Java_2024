package com.cskaoyan.javase.stack;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-07-05 11:38
 **/

public class Demo {
    public static void main(String[] args) {
        //MyLinkedStack<int> myLinkedStack = new MyLinkedStack<>();//Type argument cannot be of primitive type
        MyLinkedStack<String> myLinkedStack = new MyLinkedStack<>();
        myLinkedStack.push("zhangsan");
        myLinkedStack.push("lisi");
        myLinkedStack.push("wangwu");
        myLinkedStack.push("zhaoliu");
        //myLinkedStack FILO
        System.out.println(myLinkedStack.peek());

        myLinkedStack.pop();
        System.out.println(myLinkedStack.peek());

        myLinkedStack.pop();
        System.out.println(myLinkedStack.peek());

        myLinkedStack.pop();
        System.out.println(myLinkedStack.peek());

//        myLinkedStack.pop();
//        System.out.println(myLinkedStack.peek());
    }
}
