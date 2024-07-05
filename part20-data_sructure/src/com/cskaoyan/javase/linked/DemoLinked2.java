package com.cskaoyan.javase.linked;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 双向链表
 * @since 2024-05-23 15:50
 **/

public class DemoLinked2 {
    public static void main(String[] args) {
        DBNode a = new DBNode("A", null, null);
        DBNode b = new DBNode("B", a, null);
        DBNode c = new DBNode("C", b, null);
        DBNode d = new DBNode("D", c, null);

        a.next = b;
        b.next = c;
        c.next = d;


        //改造为循环链表
        d.next = a;
        a.pre = d;

        System.out.println(a);

    }
}

class DBNode {
    String value;
    //前指针域
    DBNode pre;
    //后指针域
    DBNode next;

    public DBNode(String value, DBNode pre, DBNode next) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }

    @Override
    public String toString() {
        return "DBNode{" +
                "value='" + value + '\'' +
//                ", pre=" + pre +
//                ", next=" + next +
                '}';
    }
}
