package com.cskaoyan.utlis;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @program: first-jdbc
 * @description: JDBC工具类
 * @create: 2024-02-18 21:42
 **/

public class JDBCUtilsOptimize {
    //获取Connection (statement)对象
    public static Connection getConnection() {

        Connection connection = null;
        try {
            //注册驱动
            //DriverManager.registerDriver(new Driver());
            String url;
            String username;
            String password;
            String driver;
            //读取配置文件
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("D:\\Java\\IdeaProjects\\Java_2024\\mysql-JDBC\\first-jdbc\\jdbc.properties");
            properties.load(fileInputStream);

            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            /*解耦*/
            Class.forName(driver);
            //建立网络连接
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("获取Connection对象异常");
        }
        return connection;
    }

    //断开连接
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
