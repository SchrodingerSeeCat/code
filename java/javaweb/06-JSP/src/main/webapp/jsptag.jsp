<%--
  Created by IntelliJ IDEA.
  User: valid
  Date: 2020/11/21
  Time: 下午12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>1</h1>
    <%--请求转发并携带参数--%>
    <jsp:forward page="jsptag2.jsp">
        <jsp:param name="key1" value="value1"/>
        <jsp:param name="key2" value="value2"/>
    </jsp:forward>

</body>
</html>
