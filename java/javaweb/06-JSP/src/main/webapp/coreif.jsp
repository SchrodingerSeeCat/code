<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--引入JSTL核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    if测试--%>
<form method="get" action="coreif.jsp">
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="提交">
</form>
<c:if test="${param.username=='admin'}" var="isAdmin">
    <c:out value="管理员登录"></c:out>
</c:if>
<c:out value="${isAdmin}"></c:out>
</body>
</html>
