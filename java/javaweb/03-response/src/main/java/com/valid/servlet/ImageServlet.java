package com.valid.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置浏览器3秒刷新一次
        resp.setHeader("refresh", "30");

        // 在内存中创建一张图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        // 得到图片
        Graphics2D graphics = (Graphics2D)image.getGraphics();
        // 设置背景图的颜色
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 80, 20);

        // 设置画笔
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font(null, Font.BOLD, 20));

        // 将随机数画到图片上
        graphics.drawString(makeNum(), 0, 20);

        // 告诉浏览器，这个请求用图片打开
        resp.setContentType("image/jpeg");
        // 设置浏览器不要缓存
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");

        // 将图片输出到浏览器
        ImageIO.write(image, "jpeg", resp.getOutputStream());
    }

    // 生成随机数
    private String makeNum() {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
