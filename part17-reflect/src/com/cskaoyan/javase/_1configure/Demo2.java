package com.cskaoyan.javase._1configure;

import sun.nio.cs.ext.GBK;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * @program: Java_2024
 * @description: 读取数据库的配置信息
 * @create: 2024-03-16 09:37
 **/

public class Demo2 {
    public static void main(String[] args) throws IOException, SQLException {
        //读取数据库的配置信息
        //创建properties对象
        Properties properties = new Properties();
        //load文件
        //properties.load(new FileInputStream("config.properties"));
        properties.load(new InputStreamReader(new FileInputStream("config.properties"), "GBK"));
        //获取属性值
        String host = properties.getProperty("host");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(host);
        System.out.println(username);
        System.out.println(password);
//        //连接数据库
//        Connection connection = DriverManager.getConnection(host, username, password);
//        // 执行查询操作
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
//
//        // 处理查询结果
//        while (resultSet.next()) {
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            int age = resultSet.getInt("age");
//            System.out.println(id + "\t" + name + "\t" + age);
//        }
//
//        // 关闭资源
//        resultSet.close();
//        statement.close();
//        connection.close();
    }
}
