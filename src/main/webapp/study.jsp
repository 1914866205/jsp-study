<%@ page import="com.example.demo.DatabaseConnection" %>
<%@ page import="com.example.dao.StudentDAOImpl" %>
<%@ page import="com.example.domain.bean.test.Student" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
    <%
        String key = request.getParameter("queryString");
        if(key==null){
            key="";
        }
        DatabaseConnection dc = new DatabaseConnection();
        StudentDAOImpl dao = new StudentDAOImpl(dc.getConnection());
        List<Student> list = dao.findAll(key);
        dc.close();
    %>
<body>
<center><h1>学生信息管理系统</h1></center>
<a href="add.jsp">增加新学生</a>
<form name ="search" action="studentlist.jsp" method="post">
    <input type="text" name="queryString"/>
    <input type="submit" value="查询"/>
</form>
<hr/>
<table border="1" width="100%">
    <tr><th>ID</th><th>姓名</th><th>生日</th><th>分数</th><th>专业</th><th>电话</th><th colspan="2">操作</th></tr>
    <%
        for(Student s: list){
    %>
    <tr>
        <td><%=s.getId()%></td>
        <td><%=s.getName()%></td>
        <td><%=s.getBirthday()%></td>
        <td><%=s.getScore()%></td>
        <td><%=s.getMajor()%></td>
        <td><%=s.getTelphone()%></td>
        <td><a href="update.jsp">修改</a></td>
        <td><a href="removedo.jsp?id=<%=s.getId()%>">删除</a></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>