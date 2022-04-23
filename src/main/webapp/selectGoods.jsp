<%@ page import="com.example.demo.JDBCConnection" %>
<%@ page import="com.example.dao.GoodsDao" %>
<%@ page import="com.example.domain.bean.Goods" %><%--
  Created by IntelliJ IDEA.
  User: nitaotao
  Date: 2022/4/23
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("query"));
    session.setAttribute("id", id);
    JDBCConnection jdbcConnection = new JDBCConnection();
    GoodsDao dao = new GoodsDao(jdbcConnection);
    Goods goods = dao.findGoodsById(id);
    jdbcConnection.close();
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
    requestDispatcher.forward(request, response);
%>
</body>
</html>
