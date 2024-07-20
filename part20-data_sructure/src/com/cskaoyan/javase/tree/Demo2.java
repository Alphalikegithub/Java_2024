package com.cskaoyan.javase.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 使用先/后序遍历+中序遍历构建二叉树
 * @since 2024-07-19 22:49
 **/

public class Demo2 {
    public static void main(String[] args) {

        //中序遍历 : [1, 10, 15, 20, 50, 70, 100, 120, 130, 150, 170, 200, 250, 300]
        List<Integer> inOrder = new LinkedList<>();
        inOrder.add(1);
        inOrder.add(10);
        inOrder.add(15);
        inOrder.add(20);
        inOrder.add(50);
        inOrder.add(70);
        inOrder.add(100);
        inOrder.add(120);
        inOrder.add(130);
        inOrder.add(150);
        inOrder.add(170);
        inOrder.add(200);
        inOrder.add(250);
        inOrder.add(300);

        //后序遍历 : [10, 15, 1, 20, 70, 50, 130, 120, 170, 150, 250, 300, 200, 100]
        List<Integer> postOrder = new LinkedList<>(Arrays.asList(
                10, 15, 1, 20, 70, 50, 130, 120, 170, 150, 250, 300, 200, 100
        ));

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.buildTreeByInAndPostOrder(inOrder, postOrder);

        System.out.println(tree);
    }
}