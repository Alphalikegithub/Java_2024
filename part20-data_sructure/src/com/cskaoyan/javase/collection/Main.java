package com.cskaoyan.javase.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Collection<String> collection = new LinkedList<>() ;
        collection.add("wang");
        collection.add("zhang");
        collection.add("liu");
        System.out.println(collection);

    }
}