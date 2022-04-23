<%@ page import="com.example.demo.JDBCConnection" %>
<%@ page import="com.example.dao.GoodsDao" %>
<%@ page import="com.example.domain.bean.Goods" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: nitaotao
  Date: 2022/4/23
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品</title>
</head>
<%
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
%>
<body>
</body>
</html>
