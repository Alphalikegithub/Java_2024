package com.cskaoyan.java53th._3other;

import java.lang.reflect.Field;

/**
 * 反射破解String对象不可变
 * 这不是常规手段,不要使用
 *
 * @since 14:41
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        String str = "hello";
        Class stringClazz = str.getClass();
        Field value = stringClazz.getDeclaredField("value");
        System.out.println(value);
        value.setAccessible(true);
        char[] arr = {'1', '2', '3'};
        value.set(str, arr);
        System.out.println(str);
    }
}
