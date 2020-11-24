<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="people" class="com.valid.pojo.People" scope="page" />
    <jsp:setProperty name="people" property="id" value="1" />
    <jsp:setProperty name="people" property="name" value="孙" />
    <jsp:setProperty name="people" property="age" value="18" />
    <jsp:setProperty name="people" property="address" value="北京" />

    id：<jsp:getProperty name="people" property="id"/>
    姓名：<jsp:getProperty name="people" property="name"/>
    年龄：<jsp:getProperty name="people" property="age"/>
    地址：<jsp:getProperty name="people" property="address"/>
</body>
</html>
