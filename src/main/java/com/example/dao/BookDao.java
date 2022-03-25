package com.example.dao;

import com.example.demo.JDBCConnection;
import com.example.domain.bean.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BookDao
 * @Descriotion 用于数据库连接
 * @Author nitaotao
 * @Date 2022/3/25 12:05
 * @Version 1.0
 **/
public class BookDao {
    JDBCConnection jdbcConnection;

    public BookDao(JDBCConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    /**
     * @return 返回所有书籍
     * @Author nitaotao
     * @Date 12:18
     * @Description
     * @MethodName allBooks
     * @Param
     **/
    public List allBooks() throws SQLException {
        Connection conn = jdbcConnection.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "select * from book";
            st = conn.prepareStatement(sql);
            ResultSet resultSet = st.executeQuery();
            List<Book> books = new ArrayList();
            while (resultSet.next()) {
                books.add(new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("author"),
                        resultSet.getDouble("money")
                ));
            }
            return books;
        } finally {
            st.close();
            conn.close();
        }
    }

    /**
     * @return 返回指定id的书籍
     * @Author nitaotao
     * @Date 12:19
     * @Description
     * @MethodName findBookById
     * @Param
     **/
    public Book findBookById(int id) throws SQLException {
        Connection conn = jdbcConnection.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "select * from book where book.id =? limit 1";
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();
            return resultSet.next() ? new Book(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("author"),
                    resultSet.getDouble("money")
            ) : null;
        } finally {
            st.close();
            conn.close();
        }
    }

    /**
     * @return 返回执行的记录数
     * @Author nitaotao
     * @Date 12:30
     * @Description
     * @MethodName updateBook
     * @Param
     **/
    public int updateBook(Book book) throws SQLException {
        Connection conn = jdbcConnection.getConnection();
        PreparedStatement st = null;
        try {

            String sql = "update book set `name`=?,author=?,money=? where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(4, book.getId());
            st.setString(1, book.getName());
            st.setString(2, book.getAuthor());
            st.setDouble(3, book.getMoney());
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
     * @MethodName insertBook
     * @Param
     **/
    public int insertBook(Book book) throws SQLException {
        Connection conn = jdbcConnection.getConnection();
        PreparedStatement st = null;
        try {

            String sql = "insert into book (id, `name`, author, money) VALUES (?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setInt(1, book.getId());
            st.setString(2, book.getName());
            st.setString(3, book.getAuthor());
            st.setDouble(4, book.getMoney());
            return st.executeUpdate();
        } finally {
            st.close();
            conn.close();
        }
    }

    /**
     * @return 返回执行的记录数
     * @Author nitaotao
     * @Date 12:35
     * @Description 删除书籍通过id
     * @MethodName deleteBookById
     * @Param
     **/
    public int deleteBookById(int id) throws SQLException {
        Connection conn = jdbcConnection.getConnection();
        PreparedStatement st = null;
        try {

            String sql = "delete  from book where book.id =?";
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            return st.executeUpdate();
        } finally {
            st.close();
            conn.close();
        }
    }
}
