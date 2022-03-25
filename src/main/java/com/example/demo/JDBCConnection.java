package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName JDBC
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/3/25 12:08
 * @Version 1.0
 **/
public class JDBCConnection {
    private static final String DBDRIVER="com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/book?useUnicode=true&characterEncoding=utf8";
    public static final String USERNAME="root";
    public static final String PASSWORD = "root";
    private Connection conn;

    public JDBCConnection() {
        //加载驱动
        try {
            Class.forName(DBDRIVER);
            //获取连接
            conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        if(conn==null||conn.isClosed()){
            conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        }
        return  this.conn;
    }

    public void close(){
        if(this.conn!=null){
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
