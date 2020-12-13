<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/upload2" enctype="multipart/form-data" method="POST">
        <input type="file" name="file">
        <input type="submit" value="upload">
    </form>
</body>
</html>
