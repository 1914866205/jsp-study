<%@ page import="com.example.demo.JDBCConnection" %>
<%@ page import="com.example.dao.GoodsDao" %>
<%@ page import="com.example.domain.bean.Goods" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.function.Predicate" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: nitaotao
  Date: 2022/4/23
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>踢出用户</title>
</head>
<%
    request.setCharacterEncoding("utf8");
    final String user = request.getParameter("user");
    Set<String> users = (Set<String>) request.getServletContext().getAttribute("user");
    users.remove(user);
    request.getServletContext().setAttribute("user", users);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
    requestDispatcher.forward(request, response);
%>
<body>
</body>
</html>
