package com.cskaoyan.test;

//import com.cskaoyan.utlis.JDBCUtils;
import com.cskaoyan.utlis.JDBCUtilsOptimize;

import java.sql.*;

/**
 * @program: first-jdbc
 * @description: 查询
 * @create: 2024-02-18 22:02
 **/

public class JDBC4Query {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtilsOptimize.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Date birth = resultSet.getDate("birth");
            System.out.println(id + ": " + name + ": " + birth);
        }
        JDBCUtilsOptimize.close(connection,statement,resultSet);
    }
}
