package com.cskaoyan;



import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: first-jdbc
 * @description: 尝试使用JDBC
 * @create: 2024-02-18 15:48
 **/

public class Main {
    static String url = "jdbc:mysql://localhost:3306/2024daydayup?useSSL=false&characterEncoding=utf8";
    static String username = "root";
    static String password = "root";
    public static void main(String[] args) throws SQLException {
        //0.注册驱动(加载驱动程序)
        DriverManager.registerDriver(new Driver());
        //1.建立网络连接
        Connection connection = DriverManager.getConnection(url,username,password);
        //2.发送SQL语句
        //statement对象主要是用来帮助我们向MySQL服务器发送SQL语句的
        //帮助我们把SQL语句封装到网络请求中
        Statement statement = connection.createStatement();
        int affectedRows = statement.executeUpdate("insert into user values (9,'小li','1995-02-03')," +
                "(10,'蜡笔小新','1999-02-18')");

        //3.获取SQL语句的执行结果
        //4.解析结果集
        System.out.println("affectedRows:" + affectedRows);
        //5.断开连接
        statement.close();
        connection.close();
        //6.
    }
}
