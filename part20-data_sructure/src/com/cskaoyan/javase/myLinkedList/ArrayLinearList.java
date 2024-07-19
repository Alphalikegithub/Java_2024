package com.cskaoyan.javase.myLinkedList;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 用数组实现线性表
 * @since 2024-07-05 12:27
 **/

public class ArrayLinearList {
    private String[] elements;
    private int size;//size 代表的是线性表中当前存储的元素个数

    public ArrayLinearList(int capacity) {
        elements = new String[capacity];
        size = 0;
    }
    public void add(String element){
        //检查数组是否已满，如果满了则扩容。
        //数组 elements 的长度（通过 elements.length 获取）表示数组的总容量，即数组可以存储的最大元素数量。
        //size 表示当前线性表中实际存储的元素数量。
        if(size == element.length()){
            throw new RuntimeException("List is full");
        }
        //扩容一般是创建一个更大的新数组，将旧数组的元素复制到新数组中
        // 在数组的末尾添加新元素
        elements[size++] = element;//元素下标后移（尾插法）
        //size++ 是后置递增运算符。后置递增运算符会先使用变量 size 当前的值，然后再对 size 进行自增。

        /*//核心逻辑
        elements[size] = element;
        size ++;*/
    }
    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size -1 ; i++) {
            //将指定索引之后的所有元素向前移动一位，覆盖掉要删除的元素。
            elements[i] = elements[i + 1];
        }
        //将最后一个元素置为 null（如果是引用类型），并更新数组的大小。
        elements[--size] = null;
    }
    public  String get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return elements[index];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    //添加一个方法来遍历输出数组中的所有元素
    public void printALL(){
        for(int i = 0;i < size;i++){
            System.out.print(elements[i] + " ");
        }
        System.out.println(); // 换行
    }
    //二叉排序树
    //二分查找树
    /*所有节点的配置都应该放在 特殊的线性表中进行相应的处理 */
}
