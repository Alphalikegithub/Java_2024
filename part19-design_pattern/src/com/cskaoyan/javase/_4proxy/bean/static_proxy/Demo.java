package com.cskaoyan.javase._4proxy.bean.static_proxy;

import com.cskaoyan.javase._4proxy.bean.V1.TianGou;
import com.cskaoyan.javase._4proxy.bean.V2.FeiYangYang;
import org.junit.Test;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-18 23:40
 **/

public class Demo {
    @Test
    public void myTest1(){
        //创建代理对象
        TianGou proxy = new TianGou();
        //调用代理对象的方法
        proxy.bufFood();
    }
    @Test
    public void myTest2(){
        FeiYangYang feiYangYang = new FeiYangYang();
        feiYangYang.bufFood();
    }
}
