package com.cskaoyan.javase.string;

import org.junit.Test;

/**
 * @program: Java_2024
 * @description: StringBufferTest测试
 * @create: 2024-02-29 17:29
 **/

public class StringBufferTest {

    @Test
    public void myTest(){
        //创建StringBuffer
        StringBuffer buffer = new StringBuffer();
        //添加功能
        buffer.append("abc");
        System.out.println(buffer);
        //插入功能
        buffer.insert(2,"de");
        System.out.println(buffer);
        //删除功能
        buffer.deleteCharAt(1);
        System.out.println(buffer);
        buffer.delete(3,4);
        System.out.println(buffer);
        //替换功能
        buffer.replace(1,2,"qpo");
        System.out.println(buffer);
        //反转功能
        buffer.reverse();
        System.out.println(buffer);


    }
}
