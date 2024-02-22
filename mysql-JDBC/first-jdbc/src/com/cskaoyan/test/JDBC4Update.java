package com.cskaoyan.test;

import com.cskaoyan.utlis.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: first-jdbc
 * @description: 增删改
 * @create: 2024-02-18 21:53
 **/

public class JDBC4Update {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        //执行SQL语句，获取结果
        int affectedRows = statement.executeUpdate("insert into user value(20,'阿呆','2024-02-18')");
        System.out.println(affectedRows);
        //关闭连接
        JDBCUtils.close(connection,statement,null);
    }
}
