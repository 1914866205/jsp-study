package com.example.easy;

import com.example.dao.GoodsDao;
import com.example.demo.JDBCConnection;
import com.example.domain.bean.Goods;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @ClassName Login
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/15 19:17
 * @Version 1.0
 **/
@WebServlet(name = "Login", urlPatterns = {"/easy-ui/servlet/good/Login"})
public class Login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("ntt".equals(username) && "123".equals(password)) {

            //算是登录了
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // RequestDispatcher requestDispatcher = request.getRequestDispatcher("/easy-ui/layout.jsp")跳转有问题
            // 参考 https://www.docin.com/p-605934816.html
            // 相对路径的问题
            response.sendRedirect("/easy-ui/layout.jsp");
        } else {
            response.sendRedirect("/easy-ui/login.html");
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/easy-ui/login.html");
//            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "我被执行了";
    }
}
