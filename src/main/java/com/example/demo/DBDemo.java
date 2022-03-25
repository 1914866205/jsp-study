package com.example.demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://101.34.47.44:3306/Study", "jsp", "jsp123");
        System.out.println(conn);
    }
}
