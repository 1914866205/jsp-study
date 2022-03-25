<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.domain.bean.Student" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="hello-servlet">九九乘法表</a>
<table border="1">
    <%
        int head;
    %>
    <tr>


        <%
            for (int i = 0; i < 10; i++) {
        %>
        <td><%=i == 0 ? "" : i%>
        </td>
        <%
            }%>
    </tr>
    <%
        for (int i = 0; i < 10; i++) {%>
    <tr>
        <%
            for (int j = 0; j <= i; j++) {%>
        <% if (i * j == 0) {
            //如果其中一个为0
            head = i == 0 ? j : i;
            if (head != 0) {
        %>
        <td><%=head%>
        </td>
        <% }
        } else { %>
        <td><%=j%>x<%=i%>=<%=i * j%>
        </td>
        <% }
        }%>
    </tr>
    <% }%>
</table>

<%
    ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    Student taotao = new Student(1, "倪涛涛", 69, 70, 60);
    Student ruirui = new Student(2, "朱瑞瑞", 49, 98, 12);
    Student yuansheng = new Student(3, "蒋元生", 92, 73, 59);
    Student yanghao = new Student(4, "杨浩浩", 93, 82, 80);
    Student girlFriend = new Student(5, "女朋友", 20, 99, 17);
    Map map = new HashMap<String, Object>();
    map.put(1, taotao);
    map.put(2, ruirui);
    map.put(3, yuansheng);
    map.put(4, yanghao);
    map.put(5, girlFriend);
    list.add(map);
%>
<table border="1" cellspacing="1" cellpadding>
    <thead>
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>平时成绩</td>
        <td>实验成绩</td>
        <td>期末成绩</td>
        <td>总评</td>
    </tr>
    </thead>
    <%
        for (int i = 1; i <= map.size(); i++) {
            Student student = (Student) map.get(i);
            System.out.println(student);

    %>
    <tr>
        <td><%=  student.getId()  %>
        </td>
        <td><%=  student.getName()%>
        </td>
        <td><%= student.getUsualPer() %>
        </td>
        <td><%=  student.getExperPer()  %>
        </td>
        <td><%=  student.getEndPer()  %>
        </td>
        <%if (student.getTotalPer() < 50) {%>
        <td style='color:red'>
            <%=student.getTotalPer()%>
        </td>
        <%
        } else {
        %>
        <td><%=student.getTotalPer()%>
        </td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>