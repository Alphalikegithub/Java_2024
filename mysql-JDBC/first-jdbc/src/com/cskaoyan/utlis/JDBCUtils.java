package com.cskaoyan.utlis;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @program: first-jdbc
 * @description: JDBC工具类
 * @create: 2024-02-18 21:42
 **/

public class JDBCUtils {
    static String url = "jdbc:mysql://localhost:3306/2024daydayup?useSSL=false&characterEncoding=utf8";
    static String username = "root";
    static String password = "root";
    //获取Connection (statement)对象
    public static Connection getConnection(){

        Connection connection = null;
        try{
            //注册驱动
            DriverManager.registerDriver(new Driver() {
                @Override
                public Connection connect(String url, Properties info) throws SQLException {
                    return null;
                }

                @Override
                public boolean acceptsURL(String url) throws SQLException {
                    return false;
                }

                @Override
                public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                    return new DriverPropertyInfo[0];
                }

                @Override
                public int getMajorVersion() {
                    return 0;
                }

                @Override
                public int getMinorVersion() {
                    return 0;
                }

                @Override
                public boolean jdbcCompliant() {
                    return false;
                }

                @Override
                public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                    return null;
                }
            });
            //建立网络连接
            connection = DriverManager.getConnection(url, username, password);
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("获取Connection对象");
        }
        return connection;
    }
    //断开连接
    public static  void close(Connection connection, Statement statement, ResultSet resultSet){
        try{
            if (connection != null)
            {
                connection.close();
            }
            if(statement != null)
            {
                statement.close();
            }
            if(resultSet != null)
            {
                resultSet.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
