<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.0.min.js"></script>
    <script>
        function a1(){
            $.post({
                url: "${pageContext.request.contextPath}/a3",
                data: {
                    "name": $("#name").val()
                },
                success: function (data) {
                    if(data.toString() === "ok") {
                        $("#userInfo").css("color", "green")
                    } else {
                        $("#userInfo").css("color", "red")
                    }
                    $("#userInfo").html(data)
                }
            })
        }
        function a2(){
            $.post({
                url: "${pageContext.request.contextPath}/a3",
                data: {
                    "pwd": $("#pwd").val()
                },
                success: function (data) {
                    if(data.toString() === "ok") {
                        $("#password").css("color", "green")
                    } else {
                        $("#password").css("color", "red")
                    }
                    $("#password").html(data)
                }
            })
        }
    </script>
</head>
<body>
    <p>
        用户名：<input type="text" id="name" onblur="a1()">
        <span id="userInfo"></span>
    </p>
    <p>
        密码：<input type="text" id="pwd" onblur="a2()">
        <span id="password"></span>
    </p>
</body>
</html>
