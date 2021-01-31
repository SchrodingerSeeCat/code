package com.valid.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;

/*
* 文件上传
* */
@Slf4j
@Controller
public class FormController {

    @GetMapping("/form_layouts")
    public String formLayouts() {
        return "form/form_layouts";
    }

    /*
    * MultipartFile自动封装上传的值
    * */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String userName,
                         @RequestParam("file") MultipartFile singleFile,
                         @RequestParam("files") MultipartFile[] manyFile) throws IOException {

        log.info(email);
        log.info(userName);

        if(!singleFile.isEmpty()) {
            // 保存到文件服务器
            singleFile.transferTo(Paths.get("D:\\code\\java\\SpringBoot2\\03_admin\\" + singleFile.getOriginalFilename()));
        }

        if(manyFile.length > 0) {
            for(MultipartFile file : manyFile) {
                if(!file.isEmpty()) {
                    singleFile.transferTo(Paths.get("D:\\code\\java\\SpringBoot2\\03_admin\\" + file.getOriginalFilename()));
                }
            }
        }
        // 上传成功返回main页面
        return "main";
    }
}
