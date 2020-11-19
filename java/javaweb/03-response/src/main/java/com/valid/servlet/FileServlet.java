package com.valid.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取下载文件的路径
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/图片.jpg");

        // 获取下载的文件名
        String fileName = path.substring(path.lastIndexOf("//") + 1);

        // 设置浏览器能够支持下载我们需要的东西
        resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));

        // 获取下载文件的输入流
        FileInputStream in = new FileInputStream(path);

        // 创建缓冲区
        byte[] buffer = new byte[1024];
        int len = 0;

        // 获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();

        // 将FileOutputStream流写入到buffer缓冲区, 并使用OutputStream将缓冲区中的数据输出到客户端
        while((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }
}
