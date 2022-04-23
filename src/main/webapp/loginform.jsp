<%--
  Created by IntelliJ IDEA.
  User: nitaotao
  Date: 2022/4/16
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<style>
    * {
        margin: 0;
        padding: 0;
    }
    html {
        height: 100%;
    }
    body {
        height: 100%;
    }
    .container {
        height: 100%;
        background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
    }
    .login-wrapper {
        background-color: #fff;
        width: 358px;
        height: 588px;
        border-radius: 15px;
        padding: 0 50px;
        position: relative;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
    }
    .header {
        font-size: 38px;
        font-weight: bold;
        text-align: center;
        line-height: 200px;
    }
    .input-item {
        display: block;
        width: 100%;
        margin-bottom: 20px;
        border: 0;
        padding: 10px;
        border-bottom: 1px solid rgb(128, 125, 125);
        font-size: 15px;
        outline: none;
    }
    .input-item:placeholder {
        text-transform: uppercase;
    }
    .btn {
        text-align: center;
        padding: 10px;
        width: 100%;
        margin-top: 40px;
        background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
        color: #fff;
    }
    .msg {
        text-align: center;
        line-height: 88px;
    }
    a {
        text-decoration-line: none;
        color: #abc1ee;
    }
</style>
<body>
<%--<h1>登录</h1>--%>
<%--<form method="post" action="session.jsp">--%>
<%--    <text>用户名：</text>--%>
<%--    <input type="text" name="username"/>--%>
<%--    <text>密码：</text>--%>
<%--    <input type="password" name="password"/>--%>
<%--    <button type="reset" name="重置">重置</button>--%>
<%--    <button type="submit" name="提交">提交</button>--%>
<%--</form>--%>
<div class="container">
    <form method="post" action="session.jsp" class="login-wrapper">
        <div class="header">Login</div>
        <div class="form-wrapper">
            <input type="text" name="username" placeholder="username" class="input-item">
            <input type="password" name="password" placeholder="password" class="input-item">
                <button  class="btn" type="reset" name="重置">重置</button>
                <button  class="btn" type="submit" name="提交">提交</button>
<%--            <div class="btn">Login</div>--%>
        </div>
        <div class="msg">
            Don't have account?
            <a href="#">Sign up</a>
        </div>
    </form>
</div>
</body>
</html>

