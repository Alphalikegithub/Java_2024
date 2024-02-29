package com.cskaoyan.javase.string;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Test
    public void myTest2() throws ParseException {
        Date date = new Date();
        System.out.println(date);
        //
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));

        //字符串转日期
        String s = "2024/02/29 19:48:00";
        Date date1 = simpleDateFormat.parse(s);
        System.out.println(date1);
    }
}
