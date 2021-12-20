package com.bigdata.hive;

import java.sql.*;

/**
 * JDBC代码操作hive
 * 注意：需要先启动hiverserver2服务
 */
public class HiveJdbcDemo {
    public static void main(String[] args) throws SQLException {
        //获取链接 这里的user使用root，即linux用户名，password随便传
        Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.11.103:10000", "root", "123");

        //获取statement
        Statement statement = conn.createStatement();

        //指定查询的sql
        String sql = "select * from t1";

        //执行sql
        ResultSet res = statement.executeQuery(sql);

        //读数据
        while(res.next()){
            System.out.println(res.getInt("id") + "\t" + res.getString("name"));
        }
    }
}
