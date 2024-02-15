package com.cskaoyan.javase._3example.operation;

import com.cskaoyan.javase._3example.model.Goods;

/**
 * @program: Java_2024
 * @description: 商品操作的接口规范，先写规范，后写接口
 * @create: 2024-01-19 23:23
 **/

public interface IGoodsOperation {
    //展示商品
    Goods[] getAllGoods();
    //新增商品
    //新增商品的插入不是真的插入，而是找到一个null的位置插入
    int insertGoods(Goods g);
}
