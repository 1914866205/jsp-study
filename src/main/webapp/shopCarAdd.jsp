<%@ page import="com.example.domain.bean.ShopCar" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.dao.GoodsDao" %>
<%@ page import="com.example.demo.JDBCConnection" %>
<%@ page import="com.example.domain.bean.Goods" %><%--
  Created by IntelliJ IDEA.
  User: nitaotao
  Date: 2022/4/23
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    // 键为商品id，值为实体
    Map<Integer, ShopCar> shopCar = null;
    if ( session.getAttribute("shopCar") == null) {
        shopCar = new HashMap<Integer, ShopCar>();
    } else {
        shopCar = (Map<Integer, ShopCar>) session.getAttribute("shopCar");
    }
    ShopCar goods = shopCar.get(id);
    if (goods == null) {
        GoodsDao dao = new GoodsDao(new JDBCConnection());
        Goods goodsItem = dao.findGoodsById(id);
        ShopCar carItem = new ShopCar();
        carItem.setGoods(goodsItem);
        carItem.setNumber(1);
        shopCar.put(id, carItem);
    }else{
        //商品存在
        ShopCar carItem = shopCar.get(id);
        carItem.setNumber((carItem.getNumber()+1));
    }
    session.setAttribute("shopCar", shopCar);
    request.getRequestDispatcher("success.jsp").forward(request,response);
%>
</body>
</html>
