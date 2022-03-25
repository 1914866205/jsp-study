package com.example.demo;

import java.math.BigDecimal;
import java.sql.*;

public class PreparedQuery {

    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://dusin.top:3306/Study";
    public static final String USERNAME = "jsp";
    public static final String PASSWORD = "jsp123";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        // 1.加载驱动
        try {
            Class.forName(DBDRIVER);
            // 2.获取连接
            conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            // 3. 创建语句 Statement
            String sql = "select * from person where salary>?";
            // 4. 预编译sql
            st = conn.prepareStatement(sql);
            // 5. 设置值
            st.setDouble(1, -1);
            // 6. 执行sql
            rs = st.executeQuery();
            // 7.遍历结果
            while (rs.next()) {
                int id = rs.getInt("pid");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Date birthday = rs.getDate("birthday");
                BigDecimal salary = rs.getBigDecimal("salary");
                System.out.println("id:" + id + ",name:" + name + ",age:" + age + ",birthday:" + birthday + ",salary:" + salary);
            }
            System.out.println(conn);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {//关闭资源
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}