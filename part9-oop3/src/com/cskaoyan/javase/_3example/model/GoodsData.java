package com.cskaoyan.javase._3example.model;

/**
 * @program: Java_2024
 * @description: 商品对象数组，用来模拟数据源
 * @create: 2024-01-19 23:19
 **/

public class GoodsData {
    public static final Goods[] GOODS = new Goods[10];
    static {
        GOODS[0] = new Goods(1,"iPhone",3499);
    }
}
