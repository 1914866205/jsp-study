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
    session.setAttribute("id", id);
    JDBCConnection jdbcConnection = new JDBCConnection();
    GoodsDao dao = new GoodsDao(jdbcConnection);
    Goods goods = dao.findGoodsById(id);
    jdbcConnection.close();
%>
<body>
<form method="post" action="updateSuccess.jsp">
     <label>商品id：<%=goods.getId()%></label>
    <p> <label>商品：<input type="text" name="name" value=<%=goods.getName()%>> </label></p>
    <p><label>价钱：<input type="text" name="price" value=<%=goods.getPrice()%>> </label></p>
    <p>
        <label>
            <input type="submit" name="Submit" value="提交"/>
        </label>
        <label>
            <input type="reset" name="reset" value="重置"/>
        </label>
    </p>
</form>
</body>
</html>
