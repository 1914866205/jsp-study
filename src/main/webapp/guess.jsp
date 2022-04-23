<%@ page import="java.util.Random" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: nitaotao
  Date: 2022/4/16
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>猜数字页面</title>
</head>
<body>
<%
    System.out.println("随机数为:" + session.getAttribute("num"));
    if (session.getAttribute("num")==null) {
        //如果为空，生成随机数存储
        final int num = new Random().nextInt(100);
        System.out.println("生成的随机数为:" + num);
        session.setAttribute("num", num);
    }else {
        PrintWriter print=response.getWriter();
        if (request.getParameter("guess") != null) {
        final int guess = Integer.parseInt(request.getParameter("guess"));
        final int num = (int) session.getAttribute("num");
        if (guess == num) {
            print.println("猜中了");
        }else if(guess > num)  {
            print.print("猜大了");
        }else {
            print.print("猜小了");
        }
        }
    }

%>
<form method="post" action="guess.jsp">
    <text>请输入1-100的数字：</text>
    <input type="number" name="guess"/>
    <button type="reset" name="重置">重置</button>
    <button type="submit" name="提交">提交</button>
</form>

</body>
</html>

