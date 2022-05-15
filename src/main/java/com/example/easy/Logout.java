package com.example.easy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName Logout
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/15 21:10
 * @Version 1.0
 **/
@WebServlet(name = "Logout", urlPatterns = {"/easy-ui/servlet/good/Logout"})
public class Logout extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //退出
        request.getSession().removeAttribute("username");
        response.sendRedirect("/easy-ui/login.html");
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

