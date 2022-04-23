package com.example.dao;

import com.example.demo.JDBCConnection;
import com.example.domain.bean.Goods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
