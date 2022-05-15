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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @ClassName Load
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/15 16:02
 * @Version 1.0
 **/
@WebServlet(name = "Load", urlPatterns = {"/easy-ui/servlet/good/Load"})
public class Load extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        //在try语句里这样写会自动调动close
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/json;character=UTF-8");
            request.setCharacterEncoding("utf-8");
            String key = request.getParameter("searchInfo");
            if (key == null) {
                key = "";
            }
            //分页参数
            int page;
            int rows;
            try {
                page = Integer.getInteger(request.getParameter("page"));
                rows = Integer.parseInt(request.getParameter("rows"));
                System.out.println("///////////");
                System.out.println("接收的key为："+key);
                System.out.println("接收的分页参数为："+page);
                System.out.println("接收的分页参数为："+rows);
                System.out.println("///////////");
            } catch (NullPointerException e) {
                page = 1;
                rows = 20;
            }

            GoodsDao goodsDao = new GoodsDao(new JDBCConnection());
            //本次的总数据量
            int total = goodsDao.findAllCount(key);
            // (page-1)*rows 是当前是第几个数据，rows是本次的数据量
            List<Goods> goods = goodsDao.findAll(key, (page - 1) * rows, rows);
            //转换成EasyUI接收的JSON格式
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", total);
            map.put("rows", goods);
            Gson gson = new GsonBuilder().create();
            String result = gson.toJson(map);
            out.println(result);
        } catch (Exception e) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, e);
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
