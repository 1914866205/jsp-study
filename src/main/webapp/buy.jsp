<%@ page import="com.example.domain.bean.ShopCar" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: nitaotao
  Date: 2022/4/23
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车结算</title>
</head>
<body>
<table border="1px" width="100%" align="center" >
    <th>商品id</th>
    <th>商品名</th>
    <th>商品单价</th>
    <th>商品数量</th>
    <th>总价</th>
<%
    Map<Integer, ShopCar> shopCar = (Map<Integer, ShopCar>) session.getAttribute("shopCar");
    Double count = 0d;
    for (Map.Entry<Integer, ShopCar> entry : shopCar.entrySet()) {
        Double price = entry.getValue().getGoods().getPrice() * entry.getValue().getNumber();
        count += price;
%>
    <tr align="center">
        <td><%=entry.getKey() %></td>
        <td><%=entry.getValue().getGoods().getName() %></td>
        <td><%=entry.getValue().getGoods().getPrice() %></td>
        <td><%=entry.getValue().getNumber() %></td>
        <td><%=entry.getValue().getGoods().getPrice() * entry.getValue().getNumber()%></td>
    </tr>
    <%} %>
    <tr>
        <td colspan="4" align="right">价格总计</td>
        <td><%=count %></td>
    </tr>
</table>
<a href="success.jsp">返回商品列表继续购物</a>
</body>
</html>
