<%--
  Created by IntelliJ IDEA.
  User: valid
  Date: 2020/11/21
  Time: 上午11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    内置对象--%>
<%
    // 保存的数据只在一个页面中有效
    pageContext.setAttribute("name1", "1");

    // 保存的数据只在一次请求中有效，请求转发会携带这个参数
    request.setAttribute("name2", "2");

    // 保存的数据在一次会话中有效
    session.setAttribute("name3", "3");

    // 保存的数据在服务器中有效
    application.setAttribute("name4", "4");
%>

<%
    // 通过寻找的方式来取
    // 取数据的顺序 page --> request --> session --> application
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
%>
<%--使用EL表达式--%>
<h1>
    <h3>${name1}</h3>
    <h3>${name2}</h3>
    <h3>${name3}</h3>
    <h3>${name4}</h3>
</h1>
</body>
</html>
