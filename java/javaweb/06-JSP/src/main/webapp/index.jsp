<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDateTime" %>
<html>
    <body>
    <%--
        JSP表达式：将程序的结果，输出到客户端
    --%>
    <%= LocalDateTime.now()%>

    <%--
        jsp 脚本片段
    --%>
    <%
        int sum = 0;
        for(int i = 0; i <= 100; i++) {
            sum+=i;
        }
        out.println("<h1>sum = " + sum + "</h1>");
    %>

    <%--在代码中嵌入HTML--%>
    <%
        for(int i = 0; i < 5; i++) {
    %>
            <h3>我是第<%=i%>次循环</h3>
    <%
        }
    %>

    <%!
        static {
            System.out.println("Loading Servlet");
        }

        private int globalVar = 0;

        public void method() {
            System.out.println("执行了自定义的方法");
        }
    %>
    </body>
</html>
