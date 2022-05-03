<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %><%--
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
    if ( "123".equals(password)) {
        Set<String> user = (Set<String>) request.getServletContext().getAttribute("user");
        if (user == null) {
            user = new HashSet<>();
            user.add(username);
            request.getServletContext().setAttribute("user", user);
        } else {
            user.add(username);
            request.getServletContext().setAttribute("user", user);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
        requestDispatcher.forward(request,response);
    }else{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("fail.jsp");
        requestDispatcher.forward(request,response);
    }
%>
</body>
</html>
