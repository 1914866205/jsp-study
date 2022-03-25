package com.example.demo;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;

public class Transaction {

    private static final String DBDRIVER="com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://dusin.top:3306/Study";
    public static final String USERNAME="jsp";
    public static final String PASSWORD="jsp123";


    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            //加载驱动
            Class.forName(DBDRIVER);
            //获取连接
            conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            //创建语句Statement
            String sql = "update person set salary=salary+? where pid = ?";
            st = conn.prepareStatement(sql);

            conn.setAutoCommit(false);

            st.setDouble(1,-1000);
            st.setInt(2,2);
            int rows = st.executeUpdate();

            //if(1==1) throw new SQLException();
            st.setDouble(1,100);
            st.setInt(2,2);
            rows = st.executeUpdate();
            conn.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {//关闭资源
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}