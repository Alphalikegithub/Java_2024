package com.cskaoyan.javase.queue;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 实现一个队列
 * 使用者 ：数据容器
 * 数据结构 ： 队列
 * 底层 ： 单链表
 * @since 2024-07-08 17:25
 **/

public class MyLinkedQueue <T> {
    private Node head;
    private Node end;
    private int size;//队列中存储了多少元素

    class Node{
        T data;//值域
        Node next;//指针域

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    /**
     * 入队操作
     * @param t
     * @return boolean
     * @author alpha
     * @since 2024/07/08 21:43
     */
    public boolean enQueue(T t){
        //判断队列是否为空
        if(isEmpty()){
            head = new Node(t,null);
            end = head;
            size ++;
            return true;
        }
        //核心逻辑
        end.next = new Node(t,null);
        end = end.next;
        size ++ ;
        return true;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     * 出队操作
     * @return T
     * @author alpha
     * @since 2024/07/08 21:43
     */
    public T deQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("queue is Empty");
        }
        //核心逻辑
        if(size == 1){
            T oldValue = head.data;
            head = null;
            end = null;
            size--;
            return oldValue;
        }
        T oldData = head.data;
        head = head.next;
        size--;
        return oldData;
    }
    /**
     * 查看队头元素
     * @return T
     * @author alpha
     * @since 2024/07/08 21:44
     */
    public T peek(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("queue is Empty");
        }
        return head.data;
    }
}
