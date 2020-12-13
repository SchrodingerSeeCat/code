package com.valid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class FileController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        // 获取文件名
        String uploadFileName = file.getOriginalFilename();

        // 如果文件名为空，直接回到首页
        if("".equals(uploadFileName)) {
            return "index";
        }

        // 上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");

        // 如果路径不存在，创建一个
        File realPath = new File(path);
        if(!realPath.exists()) {
            realPath.mkdir();
        }

        // 文件输入输出流
        InputStream is = file.getInputStream();
        OutputStream os = new FileOutputStream(new File(realPath, uploadFileName));

        // 读取和写入
        int len = 0;
        byte[] buffer = new byte[1024];
        while((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.close();
        is.close();
        return "index";
    }

    @PostMapping("/upload2")
    public String upload2(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        // 上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if(!realPath.exists()) {
            realPath.mkdir();
        }

        // 通过CommonsMultipartFile的方法直接写文件
        file.transferTo(new File(realPath, file.getOriginalFilename()));

        return "index";
    }

    @GetMapping("/download")
    public String download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 要下载的图片的地址
        String path = request.getServletContext().getRealPath("/upload");
        String fileName = "20201212数据库原理复习资料.doc";

        // 设置response响应头
        response.reset(); // 设置页面不缓存，清空buffer
        response.setCharacterEncoding("UTF-8"); // 字符编码
        response.setContentType("multipart/form-data"); // 二进制传输数据
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path, fileName);

        // 读取和写入
        InputStream in = new FileInputStream(file);
        OutputStream out = response.getOutputStream();

        int len = 0;
        byte[] buffer = new byte[1024];
        while((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        out.flush();

        // 关闭
        in.close();
        out.close();
        return "index";
    }
}
