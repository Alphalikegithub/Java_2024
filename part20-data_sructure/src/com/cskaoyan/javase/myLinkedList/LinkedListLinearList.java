package com.cskaoyan.javase.myLinkedList;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 首先抽象的数据结构应该是一个数据容器
 * @since 2024-05-23 20:58
 **/

public class LinkedListLinearList {
    private Node head;
    private int size;

    private class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListLinearList(){
        head = null;
        size = 0;
    }

    public void add(String element) {
        Node newNode = new Node(element);  // 创建一个包含新元素的新节点
        if (head == null) {  // 如果链表为空（没有头节点）
            head = newNode;  // 将新节点设置为头节点
        } else {  // 如果链表不为空
            Node current = head;  // 从头节点开始
            while (current.next != null) {  // 遍历到链表的末尾
                current = current.next;
            }
            current.next = newNode;  // 将新节点链接到链表的末尾
        }
        size++;  // 更新链表的大小
    }


    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {  // 如果要删除的是头节点
            head = head.next;  // 将头节点更新为下一个节点
        } else {  // 如果要删除的不是头节点
            Node current = head;  // 从头节点开始
            for (int i = 0; i < index - 1; i++) {  // 遍历到要删除节点的前一个节点
                current = current.next;
            }
            current.next = current.next.next;  // 将当前节点的 next 指向要删除节点的下一个节点
        }
        size--;  // 更新链表的大小
    }

    public String get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return  size == 0;
    }
}
