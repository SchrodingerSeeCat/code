package com.valid.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取上下文对象
        ServletContext context = this.getServletContext();

        String username = "小狐狸学java";
        // 将数据保存在ServletContext中
        context.setAttribute("username", username);
    }
}
