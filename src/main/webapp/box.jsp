<%--
  Created by IntelliJ IDEA.
  User: nitaotao
  Date: 2022/4/1
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style type="text/css">
    .container {
        position: relative;
        height: 700px;
        width: 100%;
        margin: 0;
        padding: 0;
    }

    .header {
        position: relative;
        height: 50px;
        line-height: 50px;

        text-align: center;
        border: 1px solid blue;
    }

    .content {
        display: inline-block;
        position: relative;
        height: 600px;
        width: 100%;
    }

    .left {
        display: inline-block;
        width: 20%;
        height: 600px;
        border: 1px solid blue;
    }

    .item {
        font-weight: 800;
        font-size: 20px;
    }

    .right {
        display: inline-block;
        font-weight: 900;
        font-size: 40px;
        width: 77%;
        height: 600px;
        border: 1px solid red;
    }

    .text {
        padding-top: 137px;
        margin-left: 40%;
    }

    .footer {
        display: inline-block;
        margin-top: 1%;
        height: 48px;
        width: 100%;
        line-height: 30px;
        text-align: center;
        border: 1px solid blue;
    }
</style>
<body>
<div class="container">
    <div class="header">212210731119 Hello World 信息管理系统</div>
    <div class="content">
        <ul class="left">
            <li class="item">首页</li>
            <li class="item">名单管理</li>
            <li class="item">考勤管理</li>
            <li class="item">作业管理</li>
            <li class="item">实验管理</li>
            <li class="item">考试管理</li>
            <li class="item">设置</li>
        </ul>
        <div class="right">
            <div class="text">
                Hello World!
            </div>
        </div>
    </div>
    <div class="footer">copyright@2020</div>
</div>
</body>
</html>
