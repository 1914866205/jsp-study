<%@ page import="com.example.domain.bean.Goods" %>
<%@ page import="com.example.dao.GoodsDao" %>
<%@ page import="com.example.demo.JDBCConnection" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: nitaotao
  Date: 2022/4/23
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf8");
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
%>
</body>
</html>
