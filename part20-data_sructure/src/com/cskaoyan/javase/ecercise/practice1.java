package com.cskaoyan.javase.ecercise;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 求链表的中间元素
 * @since 2024-05-23 17:10
 **/

public class practice1 {
    public static void main(String[] args) {
        //ff -> ee -> dd -> cc -> bb -> aa
        Node aa = new Node("aa", null);
        Node bb = new Node("bb", aa);
        Node cc = new Node("cc", bb);
        Node dd = new Node("dd", cc);
        Node ee = new Node("ee", dd);
        Node ff = new Node("ff", ee);

        String midValue = getMiddleValue(ee);
        System.out.println("midValue = " + midValue);

        Node reNode = reverseLinked(ff);
        System.out.println("reNode = " + reNode);

    }

    /**
     * 翻转链表
     * @param head
     * @return 经过反转链表的头结点
     */
    private static Node reverseLinked(Node head) {
        //使用头插法就ok了
        Node reLinked = null;//定义一个新链表
        Node mid = head;//mid指定为头结点 TODO 定义一个遍历结点
        while(mid != null){
            Node next = mid.next;//保存旧链表遍历的下一个结点
            mid.next = reLinked;//通过头插法，把遍历结点放到新的翻转链表上

            reLinked = mid;//头插法

            mid = next;//标记回到原链表上
        }
        return reLinked;
    }

    /**
     * 获取链表的中间元素
     * @param head :一个链表的头结点
     * @return
     */
    private static String getMiddleValue(Node head) {
        Node fast = head;//快指针
        Node low  = head;//慢指针


        //判断快指针有没有走到尾部
        while (fast.next != null && fast.next.next != null){
            //向后走
            fast = fast.next.next;
            low = low.next;
        }
        /*while (fast != null && fast.next != null){
            //向后走
            fast = fast.next.next;
            low = low.next;
        }*/
        return low.value;
    }
}

class Node{
    String value;
    Node next;

    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", next=" + next +
                '}';
    }
}
