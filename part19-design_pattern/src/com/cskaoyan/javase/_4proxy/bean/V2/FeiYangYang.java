package com.cskaoyan.javase._4proxy.bean.V2;

import com.cskaoyan.javase._4proxy.bean.BuyBreakfast;
import com.cskaoyan.javase._4proxy.bean.V1.XiaoMei;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 代理类
 * @since 2024-03-18 23:33
 **/
//继承的方式
public class FeiYangYang extends MeiYangYang implements BuyBreakfast {

    @Override
    public void bufFood() {
        System.out.println("买个鸡蛋");
        //完成委托类的方法
        super.bufFood();
        System.out.println("再加一份牛奶");
    }
}
