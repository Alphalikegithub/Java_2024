package com.cskaoyan.javase.generic;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 实现一个泛型容器
 * @since 2024-07-05 10:24
 **/

public class DemoGeneric2 {
    public static void main(String[] args) {
        MyCollection<String> collection = new MyCollection<>();
        collection.add("zhangsan");
        collection.add(("lisi"));
    }
}

class MyCollection<T extends Comparable<T>> {
    //Object[] objects;
    T[] objects;
    int size;
    public  void add(T t){
        objects[0].compareTo(t);
    }
}

class User implements Comparable<User>{

    @Override
    public int compareTo(User o) {
        return 0;
    }
}
