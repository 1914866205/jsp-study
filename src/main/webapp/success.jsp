<%@ page import="com.example.domain.bean.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.dao.GoodsDao" %>
<%@ page import="com.example.demo.JDBCConnection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Set" %>
Created by IntelliJ IDEA.
User: nitaotao
Date: 2022/4/16
Time: 17:46
To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="selectFail.jsp" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>首页</title>
</head>
<h1>当前有 <span style="color: blue">
    <%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%>人在线
</h1>

<table border="1" width="100%">
    <tr>
        <th>当前在线用户</th>
        <th colspan="2">操作</th>
    </tr>
    <%
        Set<String> users = (Set<String>) request.getServletContext().getAttribute("user");
        for (String user : users) {
    %>
    <tr>
        <td><%=user%>
        </td>
        <td><a href="DelUser.jsp?user=<%=user%>">踢出</a></td>
    </tr>
    <%
        }
    %>
</table>

<%
    GoodsDao dao = new GoodsDao(new JDBCConnection());
    List<Goods> list = dao.allGoods();
    if (session.getAttribute("id") != null) {
        list = null;
        list = new ArrayList<Goods>();
        int id = (int) session.getAttribute("id");
        Goods goodsById = dao.findGoodsById(id);
        list.add(goodsById);
        session.removeAttribute("id");

    }
    int count = 1;
    if (application.getAttribute("count") == null) {
        application.setAttribute("count", 1);
    } else {
        count = (int) application.getAttribute("count");
        count++;
        application.setAttribute("count", count);
    }
%>
<body>
<h1>登录成功</h1>
<%--<center>这是第<%=count%>个访问者!</center>--%>
<center><h1>商城</h1></center>
<a href="addGoods.jsp">增加新商品</a>
<form name="search" action="selectGoods.jsp" method="post">
    <input type="text" name="query"/>
    <input type="submit" value="查询指定id的商品"/>
</form>
<hr/>
<table border="1" width="100%">
    <tr>
        <th>ID</th>
        <th>商品名</th>
        <th>价格</th>
        <th colspan="2">操作</th>
    </tr>
    <%
        for (Goods s : list) {
    %>
    <tr>
        <td><%=s.getId()%>
        </td>
        <td><%=s.getName()%>
        </td>
        <td><%=s.getPrice()%>
        </td>
        <td>
            <a href="shopCarAdd.jsp?id=<%=s.getId()%>">加入购物车</a></td>
        <td><a href="updateGoods.jsp?id=<%=s.getId()%>">修改</a></td>
        <%--        <td><a href="deleteGoods.jsp?id=<%=s.getId()%>">删除</a></td>--%>
        <td><a href="DelGoodsServlet?id=<%=s.getId()%>">删除</a></td>
    </tr>
    <%
        }
    %>
</table>
<a href="buy.jsp">去结算</a>

</body>
</html>
