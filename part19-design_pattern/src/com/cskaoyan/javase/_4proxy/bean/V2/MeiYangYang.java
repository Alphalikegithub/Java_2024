package com.cskaoyan.javase._4proxy.bean.V2;

import com.cskaoyan.javase._4proxy.bean.BuyBreakfast;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 委托类
 * @since 2024-03-18 23:33
 **/

public class MeiYangYang implements BuyBreakfast {
    @Override
    public void bufFood() {
        System.out.println("买个包子");
    }
}
