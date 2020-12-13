<%--
  Created by IntelliJ IDEA.
  User: valid
  Date: 2020/12/13
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>首页</h1>
    <span>${username}</span>
    <span><a href="${pageContext.request.contextPath}/user/loginout">注销</a></span>
</body>
</html>
