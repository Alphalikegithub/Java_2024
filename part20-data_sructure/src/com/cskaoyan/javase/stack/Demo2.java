package com.cskaoyan.javase.stack;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 测试MyArrayStack
 * @since 2024-07-08 14:49
 **/

public class Demo2 {
    public static void main(String[] args) {
        MyArrayStack<String> stack = new MyArrayStack<>(2);
        stack.push("zs");
        stack.push("ls");
        stack.push("wu");
        System.out.println(stack);

        String pop = stack.pop();
        System.out.println(pop);

        stack.push("zl");
        String peek = stack.peek();
        System.out.println(peek);
        System.out.println(stack);

    }
}
