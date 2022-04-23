<%@ page import="com.example.dao.GoodsDao" %>
<%@ page import="com.example.demo.JDBCConnection" %>
<%@ page import="com.example.domain.bean.Goods" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: nitaotao
  Date: 2022/4/23
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>
    查询商品不存在！正在跳转首页
</h1>
<%
    session.removeAttribute("id");
    response.setHeader("refresh","1,url=success.jsp");
%>
</body>
</html>
