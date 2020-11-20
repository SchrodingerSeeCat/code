<html >
    <meta charset="UTF-8">
    <body>
        <h2>Hello World!</h2>

<%--        ${pageContext.request.contextPath()}代表当前项目的路径--%>
        <form action="${pageContext.request.contextPath}/login" method="get">
            用户名：<input type="text" name="username">
            密码：<input type="password" name="password">
            <input type="submit">
        </form>

    </body>
</html>
