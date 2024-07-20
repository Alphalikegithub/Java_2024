package com.cskaoyan.javase.tree;
import com.cskaoyan.javase.tree.BinarySearchTree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class BinarySearchTreeTest1 {

    @Test
    void buildTreeByInAndPreOrder_ShouldConstructTreeFromInAndPreOrder() {
        // Arrange
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        List<Integer> inOrderList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> preOrderList = Arrays.asList(4, 2, 1, 3, 5, 6);

        // Act
        tree.buildTreeByInAndPreOrder(inOrderList, preOrderList);

        // Assert
        List<Integer> expectedInOrderTraversal = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actualInOrderTraversal = tree.inorderTraversal();
        assertEquals(expectedInOrderTraversal, actualInOrderTraversal);
    }

    @Test
    void buildTreeByInAndPreOrder_ShouldNotConstructTreeForEmptyInput() {
        // Arrange
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        List<Integer> inOrderList = Arrays.asList();
        List<Integer> preOrderList = Arrays.asList();

        // Act
        tree.buildTreeByInAndPreOrder(inOrderList, preOrderList);

        // Assert
        assertTrue(tree.isEmpty());
    }

    @Test
    void buildTreeByInAndPreOrder_ShouldHandleDuplicateValuesInOrder() {
        // Arrange
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        List<Integer> inOrderList = Arrays.asList(1, 2, 2, 3, 4, 5, 6);
        List<Integer> preOrderList = Arrays.asList(4, 2, 1, 2, 3, 5, 6);

        // Act
        tree.buildTreeByInAndPreOrder(inOrderList, preOrderList);

        // Assert
        List<Integer> expectedInOrderTraversal = Arrays.asList(1, 2, 2, 3, 4, 5, 6);
        List<Integer> actualInOrderTraversal = tree.inorderTraversal();
        assertEquals(expectedInOrderTraversal, actualInOrderTraversal);
    }
}