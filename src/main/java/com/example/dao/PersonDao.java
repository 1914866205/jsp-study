package com.example.dao;

import com.example.demo.DatabaseConnection;
import com.example.domain.bean.Person;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class PersonDao {
    private static final String DBDRIVER="com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://dusin.top:3306/Study";
    public static final String USERNAME="jsp";
    public static final String PASSWORD="jsp123";

    DatabaseConnection dbc;


    public PersonDao(DatabaseConnection dbc) {
        this.dbc = dbc;
    }

    public boolean doCreate(String name, int age, String birthday, double salary) throws SQLException {
        boolean flag = true;

        Connection conn = dbc.getConnection();
        PreparedStatement st = null;

        try {

            //创建语句Statement
            String sql = "insert into person(name,age,birthday,salary) values (?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1,name);
            st.setInt(2,age);
            st.setString(3,birthday);
            st.setDouble(4,salary);

            int rows = st.executeUpdate();

        } catch (SQLException e) {
            flag=false;
            e.printStackTrace();
        } finally {

            st.close();
            dbc.close();

        }

        return flag;

    }

    List<Map<String,Object>> findAll(){
        List<Map<String,Object>> personList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            //加载驱动
            Class.forName(DBDRIVER);
            //获取连接
            conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            //创建语句Statement
            String sql = "select * from person";
            st = conn.prepareStatement(sql);

            rs = st.executeQuery();
            while(rs.next()){ //遍历结果集
                int id = rs.getInt("pid");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Date birthday = rs.getDate("birthday");
                BigDecimal salary = rs.getBigDecimal("salary");
                //System.out.println("id:"+id+",name:"+name+",age:"+age+",birthday:"+birthday+",salary:"+salary);

                Map<String,Object> p = new HashMap<>();
                p.put("id",id);
                p.put("name",name);
                p.put("age",age);
                p.put("birthday",birthday);
                p.put("salary",salary);

                personList.add(p);
            }
            System.out.println(conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {//关闭资源
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return  personList;
    }
    public boolean doCreate(Person p) throws SQLException {
        boolean flag = true;

        Connection conn = dbc.getConnection();
        PreparedStatement st = null;

        try {

            //创建语句Statement
            String sql = "insert into person(name,age,birthday,salary) values (?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1,p.getName());
            st.setInt(2,p.getAge());
            st.setDate(3,p.getBirthday());
            st.setDouble(4, p.getSalary());

            int rows = st.executeUpdate();

        } catch (SQLException e) {
            flag=false;
            e.printStackTrace();
        } finally {

            st.close();
            dbc.close();

        }

        return flag;

    }

}
