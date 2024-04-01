package com.cskaoyan.javase._4proxy.jdk_proxy;

import com.cskaoyan.javase._4proxy.bean.BuyBreakfast;
import com.cskaoyan.javase._4proxy.bean.V1.TianGou;
import com.cskaoyan.javase._4proxy.bean.V1.XiaoMei;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-19 00:12
 **/

public class Demo2 {
    public static void main(String[] args) {
        //创建委托类对象
        XiaoMei delegate = new XiaoMei();
        //保留代理类的字节码文件
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        //创建这个代理对象
        BuyBreakfast proxyInstance = (BuyBreakfast )Proxy.newProxyInstance(XiaoMei.class.getClassLoader(),
                XiaoMei.class.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("买个鸡腿");
                        //要执行委托类里面的方法
                        Object invoke = method.invoke(delegate, args);
                        System.out.println("再加一碗豆腐脑");
                        return invoke;
                    }
                });
        //执行代理的方法
        proxyInstance.bufFood();
    }
}
