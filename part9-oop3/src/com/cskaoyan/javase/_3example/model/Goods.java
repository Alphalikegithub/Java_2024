package com.cskaoyan.javase._3example.model;

import java.lang.ref.SoftReference;

/**
 * @program: Java_2024
 * @description: 商品类
 * @create: 2024-01-19 23:18
 **/

public class Goods {
    private int id;
    private String name;
    private double price;
    public Goods(){

    }
    public Goods(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public void  print()
    {
        System.out.println("ID为"+  id + "的商品，名字是"+ name + "价格是：" + price);
    }

    public int getId() {
        return id;
    }
}
