<%@ page import="java.util.List" %>
<%@ page import="com.example.main.GetEarthData4s" %>
<%@ page import="java.net.URL" %>
<%@ page import="static com.example.main.GetEarthData4s.USGS_REQUEST_URL" %>
<%@ page import="static com.example.main.GetEarthData4s.makeHttpRequest" %>
<%@ page import="com.example.domain.bean.earthbean.JsonRootBean" %>
<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="com.example.domain.bean.earthbean.Features" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: nitaotao
  Date: 2022/5/5
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>地震数据</title>
</head>
<%
    String message = null;
    URL url = new URL(USGS_REQUEST_URL + "?format=geojson&limit=10&minmag=6&orderby=time");
    message = makeHttpRequest(url);
    //获取数据
    JsonRootBean jsonRootBean = JSON.parseObject(message, JsonRootBean.class);
    List<Features> features = jsonRootBean.getFeatures();

%>
<body>
<center><h1>地震数据</h1></center>
<table border="1" width="100%">
    <tr>
        <th>震级</th>
        <th>地址</th>
        <th>时间</th>
        <th>URL</th>
    </tr>
    <%

        for (Features feature : features) {
    %>
    <tr>
        <td><%=feature.getProperties().getMag()%>
        </td>
        <td><%=feature.getProperties().getPlace()%>
        </td>
        <td><%=
        new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(feature.getProperties().getTime())
        %>
        </td>
        <td><%=feature.getProperties().getUrl()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
