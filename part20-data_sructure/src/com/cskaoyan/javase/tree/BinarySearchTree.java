package com.cskaoyan.javase.tree;

import com.cskaoyan.javase.queue.MyArrayQueue;
import com.cskaoyan.javase.stack.MyArrayStack;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 实现一个二叉搜索树
 * 使用者：数据容器
 * 数据结构：二叉搜索树
 * 底层结构：链表
 * @since 2024-07-15 22:43
 **/

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;//持有树的根节点
    private int size;

    class Node {
        T value;//值域
        Node left;//左指针域
        Node right;//右指针域

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 二叉搜索树的添加方法
     *
     * @param value 要添加的值
     * @return 添加成功返回 true，如果值已存在则返回 false
     */
    public boolean add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("参数值不能为空");
        }

        // 如果树为空，新值作为根节点
        if (isEmpty()) {
            root = new Node(value);
            size++;
            return true;
        }

        // 遍历找到插入位置
        Node current = root;
        Node parent = null;
        int compare = -1;
        while (current != null) {
            compare = value.compareTo(current.value);
            if (compare < 0) {
                parent = current;
                current = current.left;
            } else if (compare > 0) {
                parent = current;
                current = current.right;
            } else {
                // 值已存在，返回 false
                return false;
            }
        }

        // 插入新节点
        if (compare < 0) {
            parent.left = new Node(value);
        } else {
            parent.right = new Node(value);
        }
        size++;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 二叉搜索树的删除方法
     *
     * @param value 要删除的值
     * @return 删除成功返回 true，如果值不存在返回 false
     */
    public boolean remove(T value) {
        if (value == null) {
            throw new IllegalArgumentException("参数值不能为空");
        }

        // 如果树为空，抛出异常或返回 false，这里假设直接抛出异常
        if (isEmpty()) {
            throw new RuntimeException("树为空");
        }
        //TODO 先根据提供的value找到这个值，是三种情况
        // 查找要删除的节点及其父节点
        Node current = root;
        Node parent = null;
        while (current != null) {
            int compare = value.compareTo(current.value);
            if (compare < 0) {
                parent = current;
                current = current.left;
            } else if (compare > 0) {
                parent = current;
                current = current.right;
            } else {
                // 找到要删除的节点 current
                break;
            }
        }

        // 如果没有找到要删除的值，返回 false
        if (current == null) {
            return false;
        }

        // 处理删除节点的情况
        if (current.left != null && current.right != null) {
            // 要删除的节点有两个子节点的情况
            /*
             * 如果选择左子树的最大节点作为替换节点，则应该单独实现另外的逻辑来处理这种情况。
             * 混合使用两种策略可能会导致代码结构复杂化，并增加错误的可能性，因此一般不建议这样做。
             * */
            // 找到右子树的最小节点替代要删除的节点
            Node minNode = current.right;
            Node minNodeParent = current;
            while (minNode.left != null) {
                minNodeParent = minNode;
                minNode = minNode.left;
            }

            // 将最小节点的值赋给要删除的节点
            current.value = minNode.value;

            // 更新 current 和 parent 指向要删除的节点和其父节点
            current = minNode;
            parent = minNodeParent;
        }

        // 要删除节点只有一个子节点或没有子节点的情况
        Node child = (current.left != null) ? current.left : current.right;

        // 如果要删除的是根节点
        if (parent == null) {
            root = child;
        } else if (parent.left == current) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        size--;
        return true;
    }

    /**
     * 中序遍历二叉搜索树
     * 1.定义一个标记结点，指向根结点
     * 2.循环：若栈不为空或者标记结点不为null
     * 2.1循环：如果标记结点不为null,把标记结点的left序列全部入栈
     * 2.2出栈一个元素，放到list中
     * 2.3把标记结点标记到出栈元素的right孩子上
     */


    public List<T> inorderTraversal1() {
        //创建一个容器，保存遍历结果
        LinkedList<T> list = new LinkedList<>();
        //创建一个栈
        MyArrayStack<Node> nodeMyArrayStack = new MyArrayStack<>();
        //定义一个标记结点
        Node current = root;
        //2.循环：若栈不为空或者标记结点不为null
        while (!nodeMyArrayStack.isEmpty() || current != null) {
            //2.1循环：如果标记结点不为null,把标记结点的left序列全部入栈
            while (current != null) {
                nodeMyArrayStack.push(current);
                current = current.left;
            }
            //2.2出栈一个元素，放到list中
            Node pop = nodeMyArrayStack.pop();
            list.add(pop.value);
            //2.3把标记结点标记到出栈元素的right孩子上
            current = pop.right;
        }
        return list;
    }

    /**
     * 中序遍历二叉搜索树（递归实现），返回所有节点的值的字符串表示
     */
    public List<T> inorderTraversal() {
        LinkedList<T> list = new LinkedList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(Node node, List<T> list) {
        if (node != null) {
            inorderTraversal(node.left, list);
            list.add(node.value);
            inorderTraversal(node.right, list);
        }
    }

    //层级遍历
    public List<T> levelOrder() {
        List<T> list = new LinkedList<>();
        //创建一个队列
        MyArrayQueue<Node> queue1 = new MyArrayQueue<>();
        Queue<Node> nodes = new ArrayDeque<>();
        //1.把根结点入队列
        queue1.enQueue(root);
        //2.循环（队列为空为止）
        while (!queue1.isEmpty()) {
            //出队列一个元素
            Node node = queue1.deQueue();
            //遍历
            list.add(node.value);
            //左右孩子入队列
            if (node.left != null) {
                ///queue1.enQueue(node.left);
                queue1.enQueue(node.left);
            }
            if (node.right != null) {
                queue1.enQueue(node.right);
            }
        }
        return list;
    }

    //后序遍历
    /*
    1.根结点入栈
    2.循环：(if 栈不空）
        出栈一个元素
        头插法依次添加出栈的元素
        left子结点先入栈
        right子结点后入栈
    * */
    public List<T> postOrder() {
        //存储遍历结果的容器
        List<T> list = new LinkedList<>();

        //创建一个栈
        MyArrayStack<Node> nodeMyArrayStack = new MyArrayStack<>();
        //1.根结点入栈
        nodeMyArrayStack.push(root);

        //2.循环（栈不空为止）
        while (!nodeMyArrayStack.isEmpty()) {
            //出栈元素
            Node pop = nodeMyArrayStack.pop();
            //头插法遍历
            list.add(0, pop.value);

            //将刚才出栈结点的左右孩子入栈
            if (pop.left != null) {
                nodeMyArrayStack.push(pop.left);
            }
            if (pop.right != null) {
                nodeMyArrayStack.push(pop.right);
            }
        }
        return list;
    }

    /*
    * 后序遍历的顺序是：左子树 -> 右子树 -> 根节点。下面是详细的步骤：
    递归出口：如果当前节点 (node) 为空，直接返回。这是递归的结束条件，确保我们在遇到叶子节点的孩子（即 null）时不再继续递归。
    递归调用：对于每个节点，先递归遍历其左子树，然后递归遍历其右子树，最后处理当前节点（将其值添加到列表中）。
    * */
    //下面实现递归的后序遍历
    private void postOrder2(Node node, List<T> list) {
        if (node == null) {
            return; //递归出口
        }
        //后序遍历的遍历顺序： 左 右 根
        postOrder2(node.left, list);//遍历左子树
        postOrder2(node.right, list);//遍历右子树
        list.add(node.value);//处理当前节点
    }

    //写一个函数以调用上面的postOrder2()方法
    public List<T> postOrder2() {
        LinkedList<T> list = new LinkedList<>();
        postOrder2(root, list);// 从根节点开始递归
        return list; // 返回结果列表
    }

    //先序遍历二叉树（非递归实现）
    public List<T> preorderTraversal() {
        LinkedList<T> list = new LinkedList<>();
        MyArrayStack<Node> nodeMyArrayStack = new MyArrayStack<>();
        Node current = root;
        while (!nodeMyArrayStack.isEmpty() || current != null) {
            while (current != null) {
                list.add(current.value);
                nodeMyArrayStack.push(current);
                current = current.left;
            }
            Node pop = nodeMyArrayStack.pop();
            current = pop.right;
        }
        return list;
    }

    public List<T> preOrder() {
        LinkedList<T> list = new LinkedList<>();
        //从根结点开始递归
        preOrder(root, list);
        return list;
    }

    private void preOrder(Node root, List<T> list) {
        if (root == null) {
            return;//递归出口
        }
        //先序遍历的遍历顺序：根 左 右
        list.add(root.value);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    //先序+中序建树
    //后序+中序建树
    public void buildTreeByInAndPostOrder(List<T> inOrderList, List<T> postOrderList) {
        root = buildTreeByInAndPostOrder2(inOrderList, postOrderList);
        size = inOrderList.size();
    }

    /**
     * 根据中序和后序递归建树
     *
     * @param inOrderList   给定的中序序列
     * @param postOrderList 给定的后序序列
     * @return Node 根据中序和后序所建成树的根结点
     * @author alpha
     * @since 2024/07/19 22:56
     */
    private Node buildTreeByInAndPostOrder2(List<T> inOrderList, List<T> postOrderList) {
        //递归出口，如果中序和后序序列为空，直接返回null
        if (inOrderList.isEmpty() || postOrderList.isEmpty()) {
            return null;
        }
        //先获得根结点
        T rootValue = postOrderList.get(postOrderList.size() - 1);
        //获得根结点在中序序列中的位置
        int rootIndex = inOrderList.indexOf(rootValue);//根据值找下标
        /*
         * left子树:
         *   中序：0 - rootIndex - 1
         *   后序：0 - rootIndex - 1
         * */

        /*
         * right子树:
         *   中序：rootIndex + 1 - inOrderList.size() - 1
         *   后序：rootIndex - inOrderList.size() - 2
         * */

        /*从原本的中序和后序序列中切割出left子树的中序和后序*/
        //获得左子树的中序序列
        List<T> listLeftInorder = inOrderList.subList(0, rootIndex);
        //获得左子树的后序序列
        List<T> listLeftPostorder = postOrderList.subList(0, rootIndex);
        //根据left子树的中序和后序，递归建立left子树
        Node left = buildTreeByInAndPostOrder2(listLeftInorder, listLeftPostorder);

        /*从原本的中序和后序序列中切割出right子树的中序和后序*/
        //获得右子树的中序序列
        List<T> listRightInorder = inOrderList.subList(rootIndex + 1, inOrderList.size());
        //获得右子树的后序序列
        List<T> listRightPostorder = postOrderList.subList(rootIndex, postOrderList.size() - 1);
        //根据right子树的中序和后序，递归建立right子树
        Node right = buildTreeByInAndPostOrder2(listRightInorder, listRightPostorder);

        //构建当前的根结点
        Node node;
        node = new Node(rootValue, left, right);

        return node;
    }

    //根据前序和中序递归建树
    public void buildTreeByInAndPreOrder(List<T> inOrderList, List<T> preOrderList) {
        root = buildTreeByInAndPreOrder2(inOrderList, preOrderList);
        size = inOrderList.size();
    }

    /**
     * 根据前序和中序递归建树
     *
     * @param inOrderList  给定的中序序列
     * @param preOrderList 给定的前序序列
     * @return Node 根据前序和中序所建成树的根结点
     * @author alpha
     * @since 2024/07/19 23:42
     */
    private Node buildTreeByInAndPreOrder2(List<T> inOrderList, List<T> preOrderList) {
        //递归出口，如果中序和前序序列为空，直接返回null
        if (inOrderList.isEmpty() || preOrderList.isEmpty()) {
            return null;
        }
        //先获得根结点
        T rootValue = preOrderList.get(0);
        //获得根结点在中序序列中的位置
        int rootIndex = inOrderList.indexOf(rootValue);//根据值找下标
        /*
         * left子树:
         *   中序：0 - rootIndex - 1
         *   前序：1 - rootIndex
         * */

        /*
         * right子树:
         *   中序：rootIndex + 1 - inOrderList.size() - 1
         *   前序：rootIndex + 1
         * */

        /*从原本的中序和前序序列中切割出left子树的中序和前序*/
        //获得左子树的中序序列
        List<T> listLeftInorder = inOrderList.subList(0, rootIndex);
        //获得左子树的前序序列
        List<T> listLeftPreorder = preOrderList.subList(1, rootIndex + 1);
        //根据left子树的中序和前序，递归建立left子树
        Node left = buildTreeByInAndPreOrder2(listLeftInorder, listLeftPreorder);

        /*从原本的中序和前序序列中切割出right子树的中序和前序*/
        //获得右子树的中序序列
        List<T> listRightInorder = inOrderList.subList(rootIndex + 1, inOrderList.size());
        //获得右子树的前序序列
        List<T> listRightPreorder = preOrderList.subList(rootIndex + 1, preOrderList.size());
        //根据right子树的中序和前序，递归建立right子树
        Node right = buildTreeByInAndPreOrder2(listRightInorder, listRightPreorder);

        //构建当前的根结点
        Node node;
        node = new Node(rootValue, left, right);
        return node;
    }
}
