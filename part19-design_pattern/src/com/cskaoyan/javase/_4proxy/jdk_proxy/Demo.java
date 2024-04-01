package com.cskaoyan.javase._4proxy.jdk_proxy;

import com.cskaoyan.javase._4proxy.bean.BuyBreakfast;
import com.cskaoyan.javase._4proxy.bean.V1.XiaoMei;

import java.lang.reflect.Proxy;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-18 23:59
 **/

public class Demo {
    public static void main(String[] args) {
        //创建代理对象
        BuyBreakfast proxy = (BuyBreakfast)Proxy.newProxyInstance(XiaoMei.class.getClassLoader(),
                XiaoMei.class.getInterfaces(),
                new XiaoMeiInvocationHandler());
        //执行对象的方法
        proxy.bufFood();
    }
}
