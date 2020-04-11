package com.Kotori.jdbc.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource dataSource = null;

    static{
        try {
            Properties p = new Properties();
            // search properties path
            String path = JDBCUtil.class.getClassLoader().getResource("db.properties").getPath();
            System.out.println(path);

            FileInputStream in = new FileInputStream(path);
            p.load(in);

            dataSource = DruidDataSourceFactory.createDataSource(p); // Create Druid Source
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            //2. Obtain connection from the source
            return dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet){
        if (resultSet != null)
        {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null)
        {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null)
        {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
