package com.cskaoyan.java53th._2api._4other;

import com.cskaoyan._2reflect._2api.Student;

/**
 * 其他API
 * @since 14:36
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Class<?> stuClazz = Class.forName("com.cskaoyan._2reflect._2api.Student");
        // 此方法创建对象,需要依赖一个public修饰的无参的构造器
        Student s = (Student) stuClazz.newInstance();
        System.out.println(s);
    }
}
