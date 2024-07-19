package com.cskaoyan.javase.tree;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 二叉搜索树的测试程序
 * @since 2024-07-15 22:46
 **/

public class Demo {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.add(100);
        tree.add(50);
        tree.add(200);
        tree.add(20);
        tree.add(1);
        tree.add(15);
        tree.add(10);
        tree.add(70);
        tree.add(300);
        tree.add(150);
        tree.add(120);
        tree.add(130);
        tree.add(300);
        tree.add(250);
        tree.add(170);

        //tree.remove(100);
        System.out.println("tree = " + tree);
        // 打印二叉搜索树的所有节点
        System.out.println("中序遍历 : " + tree.inorderTraversal1());
        System.out.println("中序遍历(递归实现) : " + tree.inorderTraversal());

        System.out.println("层序遍历 : " + tree.levelOrder());

        System.out.println("后序遍历 : " + tree.postOrder());
        System.out.println("后序遍历(递归实现) : " + tree.postOrder2());

        System.out.println("先序遍历 : " + tree.preorderTraversal());
        System.out.println("先序遍历(递归实现) : " + tree.preOrder());
    }

}
