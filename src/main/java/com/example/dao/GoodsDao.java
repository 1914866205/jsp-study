package com.example.dao;

import com.example.demo.JDBCConnection;
import com.example.domain.bean.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * @ClassName GoodsDao
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/4/23 12:18
 * @Version 1.0
 **/
public class GoodsDao {
    JDBCConnection jdbcConnection;

    public GoodsDao(JDBCConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    /**
     * @return 返回所有商品
     * @Author nitaotao
     * @Description
     * @Param
     **/
    public List allGoods() throws SQLException {
        Connection conn = jdbcConnection.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "select * from goods";
            st = conn.prepareStatement(sql);
            ResultSet resultSet = st.executeQuery();
            List<Goods> goods = new ArrayList();
            while (resultSet.next()) {
                goods.add(new Goods(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price")
                ));
            }
            return goods;
        } finally {
            st.close();
            conn.close();
        }
    }

    /**
     * @return 返回指定id的商品
     * @Description
     * @Param
     **/
    public Goods findGoodsById(int id) throws SQLException {
        Connection conn = jdbcConnection.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "select * from goods where goods.id =? limit 1";
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();
            return resultSet.next() ? new Goods(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price")
            ) : null;
        } finally {
            st.close();
            conn.close();
        }
    }

    /**
     * @return 返回执行的记录数
     * @MethodName updateBook
     * @Param
     **/
    public int updateGoods(Goods goods) throws SQLException {
        Connection conn = jdbcConnection.getConnection();
        PreparedStatement st = null;
        try {

            String sql = "update goods set `name`=?,price=? where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(3, goods.getId());
            st.setString(1, goods.getName());
            st.setDouble(2, goods.getPrice());
            return st.executeUpdate();
        } finally {
            st.close();
            conn.close();
        }
    }

    /**
     * @return 返回执行的记录数
     * @Author nitaotao
     * @Date 12:31
     * @Description
     * @Param
     **/
    public int insertGoods(Goods goods) throws SQLException {
        Connection conn = jdbcConnection.getConnection();
        PreparedStatement st = null;
        try {

            String sql = "insert into goods (id, `name`,price) VALUES (?,?,?)";
            st = conn.prepareStatement(sql);
            st.setInt(1, goods.getId());
            st.setString(2, goods.getName());
            st.setDouble(3, goods.getPrice());
            return st.executeUpdate();
        } finally {
            st.close();
            conn.close();
        }
    }

    /**
     * @return 返回执行的记录数
     * @Author nitaotao
     * @Param
     **/
    public int deleteGoodsById(int id) throws SQLException {
        Connection conn = jdbcConnection.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "delete from goods where goods.id =?";
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            return st.executeUpdate();
        } finally {
            st.close();
            conn.close();
        }
    }

    /**
     * 查询某字段有关的商品的数量
     *
     * @param key
     * @return
     */
    public int findAllCount(String key) throws SQLException {

        int count = 0;
        String sql = "select count(*) from goods";
        if (key != null && !"".equals(key.trim())) {
            sql += " where `id` like ? or `name` like ? or price like ?";
        }
        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            if (key != null && !"".equals(key.trim())) {
                key = "%" + key + "%";
                pstmt.setString(1, key);
                pstmt.setString(2, key);
                pstmt.setString(3, key);
                System.out.println(pstmt);
            }
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
        }
        return count;
    }

    /**
     * @return 分页查询所有商品
     * @Author nitaotao
     * @Description
     * @Param
     **/
    public List<Goods> findAll(String key, int start, int end) throws SQLException {
        List<Goods> allGoods = new ArrayList();
        String sql = "select * from goods";
        if (key != null && !"".equals(key.trim())) {
            sql += " where `id` like ? or `name` like ? or price like ?";
        }
        sql += " limit ?,?";
        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {

            if (key != null && !"".equals(key.trim())) {
                key = "%" + key + "%";
                pstmt.setString(1, key);
                pstmt.setString(2, key);
                pstmt.setString(3, key);
                pstmt.setInt(4, start);
                pstmt.setInt(5, end);
                System.out.println(pstmt);
            } else {
                pstmt.setInt(1, start);
                pstmt.setInt(2, end);
            }
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                allGoods.add(new Goods(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price")
                ));
            }
            resultSet.close();
        } catch (Exception e) {
            Logger.getLogger(Goods.class.getName()).log(Level.SEVERE, null, e);
        }
        return allGoods;
    }
}
