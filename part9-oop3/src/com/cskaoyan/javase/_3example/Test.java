package com.cskaoyan.javase._3example;

import com.cskaoyan.javase._3example.model.Goods;
import com.cskaoyan.javase._3example.operation.impl.IGoodsOperationImpl;

/**
 * @program: Java_2024
 * @description: 接口表示和规范
 * @create: 2024-01-19 23:16
 **/
//用一个页面来展示全部商品
public class Test {
    public static void main(String[] args) {
        IGoodsOperationImpl operation = new IGoodsOperationImpl();
        Goods[] allGoods = operation.getAllGoods();
        for (Goods g : allGoods) {
            g.print();
        }


        //插入商品
        System.out.println("------------------");
        switch (operation.insertGoods(new Goods(2,"QT斗地主项目",499))){
            case 0:
                System.out.println("插入成功");
                System.out.println("商品列表如下：");
                for (Goods goods : operation.getAllGoods()){
                    goods.print();
                }
                break;
            case 1:
                System.out.println("插入失败！数组满了");
                break;
            case 2:
                System.out.println("插入失败！商品ID重复");
                break;
        }

    }
}
