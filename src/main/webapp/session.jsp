<%--
  Created by IntelliJ IDEA.
  User: nitaotao
  Date: 2022/4/16
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session</title>
</head>
<body>
<%--session设置值--%>
<%
    String username = request.getParameter("username");
    session.setAttribute("username", username);
    String password =  request.getParameter("password");
    session.setAttribute("password", password);
    System.out.println(username);
    System.out.println(password);
    if ("ntt".equals(username) && "123".equals(password)) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
        requestDispatcher.forward(request,response);
    }else{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("fail.jsp");
        requestDispatcher.forward(request,response);
    }
%>
</body>
</html>
