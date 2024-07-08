package com.cskaoyan.javase.queue;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 测试用链表实现的队列
 * @since 2024-07-08 21:49
 **/

public class DemoLinkedQueue {
    public static void main(String[] args) {
        MyLinkedQueue<String> queue = new MyLinkedQueue<>();
        queue.enQueue("lihua");
        queue.enQueue("haohongmei");
        queue.enQueue(("lizicheng"));

        String peek = queue.peek();
        System.out.println("peek = " + peek);

        String deQueue = queue.deQueue();
        System.out.println("s = " + deQueue);

        System.out.println("queue.peek() = " + queue.peek());

    }
}
