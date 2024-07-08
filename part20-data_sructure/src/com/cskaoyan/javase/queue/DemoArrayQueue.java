package com.cskaoyan.javase.queue;

import java.util.NoSuchElementException;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-07-08 22:17
 **/

public class DemoArrayQueue {
    public static void main(String[] args) {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>();

        System.out.println("入队操作:");
        for (int i = 1; i <= 5; i++) {
            queue.enQueue(i);
            System.out.println("入队: " + i);
            System.out.println("当前队头: " + queue.peek());
            System.out.println("当前队列大小: " + queue.size());
            System.out.println("------");
        }

        System.out.println("出队操作:");
        while (!queue.isEmpty()) {
            int removed = queue.deQueue();
            System.out.println("出队: " + removed);
            if (!queue.isEmpty()) {
                System.out.println("新的队头: " + queue.peek());
            } else {
                System.out.println("队列为空");
            }
            System.out.println("当前队列大小: " + queue.size());
            System.out.println("------");
        }

        System.out.println("测试异常情况:");
        try {
            queue.deQueue();
        } catch (NoSuchElementException e) {
            System.out.println("捕获异常: " + e.getMessage());
        }

        try {
            queue.peek();
        } catch (NoSuchElementException e) {
            System.out.println("捕获异常: " + e.getMessage());
        }

        System.out.println("扩容测试:");
        for (int i = 1; i <= 15; i++) {
            queue.enQueue(i);
            System.out.println("入队: " + i);
        }
        System.out.println("扩容后的队列大小: " + queue.size());
        System.out.println("当前队头: " + queue.peek());


    }
}
