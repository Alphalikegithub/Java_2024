package com.cskaoyan;


import com.mysql.cj.jdbc.Driver;

import java.sql.*;

/**
 * @program: first-jdbc
 * @description: 尝试使用JDBC
 * @create: 2024-02-18 15:48
 **/

public class MainQuery2 {
    static String url = "jdbc:mysql://localhost:3306/2024daydayup?useSSL=false&characterEncoding=utf8";
    static String username = "root";
    static String password = "root";

    public static void main(String[] args) throws SQLException {
        //0.注册驱动(加载驱动程序)
        DriverManager.registerDriver(new Driver());
        //1.建立网络连接
        Connection connection = DriverManager.getConnection(url, username, password);
        //2.发送SQL语句
        //statement对象主要是用来帮助我们向MySQL服务器发送SQL语句的
        //帮助我们把SQL语句封装到网络请求中
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user where id > 3");

        //3.获取SQL语句的执行结果
        /*for(;;)
        {
            if(resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date birth = resultSet.getDate("birth");
                System.out.println("id:"+ id + ",name:"+ name + ",birth:" + birth);
            }else{
                break;
            }
        }*/

        while(resultSet.next())
        {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Date birth = resultSet.getDate("birth");
            System.out.println("id:"+ id + ",name:"+ name + ",birth:" + birth);
        }
        //4.解析结果集

        //5.断开连接
        resultSet.close();
        statement.close();
        connection.close();
        //6.
    }
}
