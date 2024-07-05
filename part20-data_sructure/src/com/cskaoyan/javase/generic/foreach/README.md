## 二级标题
```java
package com.cskaoyan.javase.linked;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 单链表
 * @since 2024-05-23 15:50
 **/

public class DemoLinked1 {
    public static void main(String[] args) {
        Node a = new Node("A", null);
        Node b = new Node("B", null);
        Node c = new Node("C", null);
        Node d = new Node("D", null);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;

        //改造为循环链表


        System.out.println(a);

    }
}

class Node {
    String value;
    Node next;

    public Node(String value ,Node next){
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

```
**原来MarkDown做笔记这么好用**