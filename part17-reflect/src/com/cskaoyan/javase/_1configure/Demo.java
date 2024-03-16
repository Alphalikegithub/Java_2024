package com.cskaoyan.javase._1configure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @program: Java_2024
 * @description: 配置文件
 * @create: 2024-03-16 08:27
 **/

public class Demo {
    public static void main(String[] args) throws IOException {
        //创建Properties对象
        Properties properties = new Properties();
        //load加载文件
        properties.load(new FileInputStream("config.properties"));
        //获取属性值
        String app_id = properties.getProperty("APP_ID");
        System.out.println(app_id);
        //查看当前.java文件的存放路径
        File file = new File(".");
        String path = file.getAbsolutePath();
        System.out.println(path);
    }
}
