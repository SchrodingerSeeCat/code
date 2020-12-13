<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <%--失去焦点时，发起一个请求到后台--%>
    用户名：<input type="text" id="username" onblur="a()">

</body>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.5.0.min.js">
</script>
<script>
    function a(){
        $.post({
            url: "${pageContext.request.contextPath}/ajax",
            data: {
                "name": $("#username").val()
            },
            success: function (data){
                alert(data)
            }
        })
    }
</script>
</html>
