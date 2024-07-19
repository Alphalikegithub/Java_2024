package com.cskaoyan.javase.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree<>();
    }

    @Test
    void addMultipleElementsAndCheckTraversal() {
        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(70);
        tree.add(60);
        tree.add(80);
        assertEquals(Arrays.asList(20, 30, 40, 50, 60, 70, 80), tree.inorderTraversal());
    }

    @Test
    void removeLeafNodeAndCheckTraversal() {
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);
        assertTrue(tree.remove(20));
        assertEquals(Arrays.asList(30, 40, 50, 60, 70, 80), tree.inorderTraversal());
    }

    @Test
    void removeRootNodeAndCheckEmptyTree() {
        tree.add(50);
        assertTrue(tree.remove(50));
        assertTrue(tree.isEmpty());
    }

    @Test
    void checkPostOrderTraversal() {
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);
        assertEquals(Arrays.asList(20, 40, 30, 60, 80, 70, 50), tree.postOrder());
    }
}