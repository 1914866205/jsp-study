<%--
  Created by IntelliJ IDEA.
  User: nitaotao
  Date: 2022/4/23
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
<form  method="post" action="addSuccess.jsp">
    <label>商品：<input type="text" name="name"/> </label>
    <p><label>价钱：<input type="text" name="price"/> </label></p>
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
