package com.cskaoyan.java53th._1properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * .properties配置文件
 *
 * @since 11:11
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        // 如何操作properties配置文件
        // 1.创建java.util.Properties类的对象,用无参构造器创建即可
        Properties properties = new Properties();
        // 2.使用API操作这个Properties对象,来操作配置文件
        // 从输入流中读取属性列表（键和元素对）。
        // void  load(InputStream inStream)
        // 按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）。
        // void  load(Reader reader)
        FileInputStream in = new FileInputStream("config.properties");
        // 加载底层流到Properties对象中,完成读配置文件
        properties.load(in);

        // 用指定的键在此属性列表中搜索属性。
        // String  getProperty(String key)
        String username = properties.getProperty("username");
        String pwd = properties.getProperty("pwd");
        System.out.println(username);
        System.out.println(pwd);
    }
}
