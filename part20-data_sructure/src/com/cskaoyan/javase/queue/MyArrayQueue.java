package com.cskaoyan.javase.queue;
import java.util.NoSuchElementException;
/**
 * @author alpha
 * @program: Java_2024
 * @description: 用循环数组实现一个队列
 * 数据结构：队列
 * 底层结构：循环数组
 * @since 2024-07-08 21:58
 **/

public class MyArrayQueue<T> {
    private static final int INIT_CAPACITY = 10;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;
    private Object[] objects;//底层数组
    private int size;
    private int head;//数据的标记位置
    private int end;//数据的尾部标记位置（标记队列尾部后面一个位置的下标）

    //默认大小的数组
    public MyArrayQueue() {
//        objects = new Object[INIT_CAPACITY];
        this(INIT_CAPACITY);
    }

    public MyArrayQueue(int initCapacity) {
        //指定大小的数组
        if (initCapacity < 1 || initCapacity > MAX_CAPACITY) {
            throw new IllegalArgumentException("parameters is Illegal");
        }
        this.objects = new Object[initCapacity];
        this.head = 0;
        this.end = 0;
    }

    /**
     * 入队操作
     *
     * @param t
     * @return boolean
     * @author alpha
     * @since 2024/07/08 22:16
     */
    public boolean enQueue(T t) {
        //判断数组是否满了
        if (size == objects.length) {
            int newLen = getLen();
            grow(newLen);
        }

        objects[end] = t;
        end = (end + 1) % objects.length;
        size++;
        return true;
    }

    private void grow(int newLen) {
        Object[] newObjects = new Object[newLen];
        //把旧数组中的数据转移到新数组
        for (int i = 0; i < objects.length; i++) {
            //newObjects[i] = objects[i];
            //注意：这里的代码实现和之前的略有差异
            int tag = (head + i) % objects.length;
            newObjects[i] = objects[tag];//注意新的数组中元素迁移的过程，不是整体照搬
        }
        objects = newObjects;
        head = 0;
        end = size;
    }

    private int getLen() {
        int oldLen = objects.length;
        int newLen = oldLen * 2;
        //之所以判断newLen < 0，是因为可能存在溢出情况，int类型溢出后，newLen的值可能为负
        if (newLen < 0 || newLen > MAX_CAPACITY) {
            newLen = MAX_CAPACITY;
        } else if (newLen == oldLen) {
            throw new RuntimeException("newLen = oldLen");

        }
        return newLen;
    }

    /**
     * 出队操作
     *
     * @return T
     * @author alpha
     * @since 2024/07/08 22:20
     */
    public T deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        //如果队列中仅剩下一个元素，删除之后让头标志和尾标志回到数组的开始位置（0位置）
        if (size == 1) {
            T oldData = (T) objects[head];
            head = 0;
            end = 0;
            size--;
            return oldData;
        }
        //程序走到这，意味着队列中有多个元素，删除仅和队头所在位置有关系
        T oldData = (T) objects[head];
        head = (head + 1) % objects.length;
        size--;
        return oldData;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * 查看队头元素
     * @return T
     * @author alpha
     * @since 2024/07/08 22:44 
     */
    public T peek(){
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return (T)objects[head];
    }
    // 获取队列大小
    public int size() {
        return size;
    }
}


