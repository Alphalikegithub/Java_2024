package com.cskaoyan.java53th._1properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 如果配置文件中有中文等非英文字符会咋样呢?
 * 可能会读不到数据,也可能读出乱码
 * 咋解决?
 * load方法不要加载字节流,而是要加载符合要求编码集的字符流
 *
 * @since 11:18
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("config.properties");
        // 继续包装,包装成UTF-8编码集的字符流
        InputStreamReader reader = new InputStreamReader(in);

        properties.load(reader);
        String name = properties.getProperty("name");
        String age = properties.getProperty("年龄");
        String gender = properties.getProperty("性别");
        System.out.println("gender = " + gender);
        System.out.println("age = " + age);
        System.out.println("name = " + name);
    }
}
