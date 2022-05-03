package com.example.jspstudy;

import com.example.dao.GoodsDao;
import com.example.demo.JDBCConnection;
import com.example.domain.bean.Goods;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "/DelGoodsServlet")
public class DelGoodsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("删除走的是servlet");
        request.setCharacterEncoding("utf8");
        int id = Integer.parseInt(request.getParameter("id"));
        JDBCConnection jdbcConnection = new JDBCConnection();
        GoodsDao dao = new GoodsDao(jdbcConnection);
        try {
            dao.deleteGoodsById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbcConnection.close();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
        requestDispatcher.forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("删除走的是servlet");
    }
}