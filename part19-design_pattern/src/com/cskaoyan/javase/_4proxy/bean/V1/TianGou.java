package com.cskaoyan.javase._4proxy.bean.V1;

import com.cskaoyan.javase._4proxy.bean.BuyBreakfast;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 代理类 静态代理方式一:成员变量的方式
 * @since 2024-03-18 23:33
 **/
//成员变量的方式
public class TianGou implements BuyBreakfast {
    //定义成员变量
    XiaoMei delegate = new XiaoMei();
    @Override
    public void bufFood() {
        System.out.println("买个鸡蛋");
        //完成委托类的方法
        delegate.bufFood();
        System.out.println("再加一份牛奶");
    }
}
