package com.cskaoyan.javase._3example.operation.impl;

import com.cskaoyan.javase._3example.model.Goods;
import com.cskaoyan.javase._3example.model.GoodsData;
import com.cskaoyan.javase._3example.operation.IGoodsOperation;

/**
 * @program: Java_2024
 * @description: 具体实现商品类的操作
 * @create: 2024-01-19 23:26
 **/

public class IGoodsOperationImpl implements IGoodsOperation {
    private Goods[] goods = GoodsData.GOODS;

    //返回商品对象数组中的真实商品对象
    //主要工作是排除null元素

    @Override
    public Goods[] getAllGoods() {
        int count = 0;
        for (Goods goods1 : goods) {
            if (goods1 != null) {
                count++;
            }
        }
        Goods[] result = new Goods[count];
        int newIndex = 0;
        for(Goods g : goods)
        {
            if(g != null)
            {
                result[newIndex] = g;
                newIndex ++;
            }
        }
        return result;
    }

    @Override
    public int insertGoods(Goods g)
    {
        //确保商品ID是唯一的
        int idInput = g.getId();
        for (Goods allGood : getAllGoods()) {
            if(allGood.getId() == idInput){
                return 2;
            }
        }
        //代码运行到这里，一定不会重复
        for (int  i = 0;i < goods.length;i++){
            if(goods[i] != null){
                goods[i] = g;
                return 0;
            }
        }
        return 1;
    }

}
