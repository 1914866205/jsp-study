package com.example.easy.good;

import com.example.dao.GoodsDao;
import com.example.demo.JDBCConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @ClassName Del
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/15 18:49
 * @Version 1.0
 **/
@WebServlet(name = "Del", urlPatterns = {"/easy-ui/servlet/good/Del"})
public class Del extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            GoodsDao goodsDao = new GoodsDao(new JDBCConnection());
            String id = request.getParameter("id");
            goodsDao.deleteGoodsById(Integer.parseInt(id));
            out.println("{\"success\":true}");
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            out.print("{\"success\":false,\"errorMsg\":'" + msg + "'}");
        } catch (Exception ex) {
            String msg = ex.getMessage();
            out.print("{\"success\":false,\"errorMsg\":'" + msg + "'}");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
