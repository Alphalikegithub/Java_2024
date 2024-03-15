package com.cskaoyan.java53th._1properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 用Properties对象读资源目录下的properties文件
 * 底层流从文件字节输入流换成ClassLoader类加载器获取的字节输入流
 *
 * @since 11:27
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        InputStream in = ClassLoader.getSystemResourceAsStream("config.properties");
        InputStreamReader reader = new InputStreamReader(in);
        Properties properties = new Properties();
        properties.load(reader);
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        System.out.println(name);
        System.out.println(age);
        System.out.println(properties.getProperty("名字"));
        System.out.println(properties.getProperty("gender"));
    }
}
