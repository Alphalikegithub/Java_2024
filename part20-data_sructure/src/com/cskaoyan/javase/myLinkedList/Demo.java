package com.cskaoyan.javase.myLinkedList;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 使用链表/数组实现一个线性表
 *
 * @since 2024-05-23 20:56
 **/

public class Demo {
    public static void main(String[] args) {
        LinkedListLinearList list = new LinkedListLinearList();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        System.out.println("list.size() = " + list.size());// List size: 3
        System.out.println("Element at index 1: " + list.get(1));// Element at index 1: Element 2

        list.remove(1);
        System.out.println("Element at index 1 after removal: " + list.get(1)); // Element at index 1 after removal: Element 3
        System.out.println("List size after removal: " + list.size()); // List size after removal: 2

        System.out.println("------------------------------------");
        ArrayLinearList arrayList = new ArrayLinearList(10);
        arrayList.add("数组元素 1");
        arrayList.add("数组元素 2");
        arrayList.add("数组元素 3");

        System.out.println("arrayList size: " + arrayList.size()); // List size: 3
        System.out.println("Element at index 1: " + arrayList.get(1)); // Element at index 1: Element 2

        arrayList.remove(1);
        System.out.println("Element at index 1 after removal: " + arrayList.get(1)); // Element at index 1 after removal: Element 3
        System.out.println("arrayList size after removal: " + arrayList.size()); // List size after removal: 2


        arrayList.add("新添加的");
        System.out.println("List size after adding an element: " + arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
    }
}
