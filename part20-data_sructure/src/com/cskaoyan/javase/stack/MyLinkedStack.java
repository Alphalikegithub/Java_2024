package com.cskaoyan.javase.stack;



/**
 * @author alpha
 * @program: Java_2024
 * @description: 使用单链表模拟一个栈
 * @since 2024-07-05 11:05
 **/

public class MyLinkedStack <T> {
    private Node head;//链表的头部，栈顶
    private int size;//栈中存储了多少数据
    
    //入栈:push
    public boolean push(T value){
        /*Node node = new Node(value,head);
        head = node;*/
        //放到链表头部（栈顶位置）
        head = new Node(value,head);
        size ++;
        return true;
    }
    //出栈:pop
    public T pop(){
        //先检测栈中是否存储了元素
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        //保存原本的栈顶值
        T oldValue = head.value;
        head = head.next;
        size --;
        return  oldValue;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    //查看栈顶元素: peek
    public T peek(){
        //先检测栈中是否存储了元素
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return head.value;
    }
    
    class Node{
        T value;//值域
        Node next;//指针域

        public Node(T value,Node next){
            this.value = value;
            this.next = next;
        }
    }
}
