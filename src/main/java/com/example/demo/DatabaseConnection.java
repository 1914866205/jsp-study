package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName DatabaseConnection
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/3/25 11:43
 * @Version 1.0
 **/
public class DatabaseConnection {
    private static final String DBDRIVER="com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://dusin.top:3306/Study";
    public static final String USERNAME="jsp";
    public static final String PASSWORD="jsp123";

    private Connection conn;

    public DatabaseConnection(){
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

    public java.sql.Connection getConnection() throws SQLException {
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