package com.cskaoyan.javase.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author alpha
 * @program: Java_2024
 * @description: List类
 * @since 2024-07-23 00:33
 **/

public class Demo {
    public static void main(String[] args) {
//        void	add(E e)
//        将指定的元素插入列表（可选操作）。
//        boolean	hasNext()
//        返回 true如果遍历正向列表，列表迭代器有多个元素。
//        boolean	hasPrevious()
//        返回 true如果遍历反向列表，列表迭代器有多个元素。
//        E	next()
//        返回列表中的下一个元素，并且前进光标位置。
//        int	nextIndex()
//        返回随后调用 next()返回的元素的索引。
//        E	previous()
//        返回列表中的上一个元素，并向后移动光标位置。
//        int	previousIndex()
//        返回由后续调用 previous()返回的元素的索引。
//        void	remove()
//        从列表中删除由 next()或 previous()返回的最后一个元素（可选操作）。
//        void	set(E e)
//        用 指定的元素替换由 next()或 previous()返回的最后一个元素（可选操作）。
        List<String> list = new LinkedList<>(Arrays.asList("zs","ls","wu","zl"));

        List<Integer> postOrder = new LinkedList<>();
        ListIterator<String> iterator = list.listIterator(list.size());
        while(iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }

        List<String> list1 = list.subList(1, 3);
        System.out.println(list1);
    }
}
