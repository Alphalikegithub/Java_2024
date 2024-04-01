package com.cskaoyan.javase._4proxy.jdk_proxy;

import com.cskaoyan.javase._4proxy.bean.V1.XiaoMei;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-18 23:59
 **/
//实现InvocationHandler接口
public class XiaoMeiInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //定义委托类对象
        XiaoMei delegate = new XiaoMei();
        //proxy 代理对象
        //method 要执行的委托类的方法
        //args 方法参数
        System.out.println("买个鸡腿");
        Object invoke = method.invoke(delegate, args);
        System.out.println("再加一碗豆腐脑");
        return invoke;
    }
}
