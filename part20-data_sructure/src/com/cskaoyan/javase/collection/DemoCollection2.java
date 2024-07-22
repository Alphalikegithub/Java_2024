package com.cskaoyan.javase.collection;

import java.util.Iterator;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-07-22 23:23
 **/

public class DemoCollection2 {
    public static void main(String[] args) {
        User user = new User();

    }

}

class User implements Iterable{
    String name;
    int age;

    public User() {
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    class Itr implements Iterator{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }
}
