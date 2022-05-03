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

@WebServlet(name = "/UpdateGoodsServlet")
public class UpdateGoodsServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("修改走的是servlet");
        request.setCharacterEncoding("utf8");
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        JDBCConnection jdbcConnection = new JDBCConnection();
        GoodsDao dao = new GoodsDao(jdbcConnection);
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName(name);
        goods.setPrice(price);
        try {
            dao.deleteGoodsById(id);
            dao.insertGoods(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbcConnection.close();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
        requestDispatcher.forward(request, response);
    }
}